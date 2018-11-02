package com.example;

import com.example.obj.country.CountryDTO;
import com.example.obj.region.RegionsDTO;
import com.example.obj.vacancy.VacancyDTO;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final Gson gson = new Gson();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String countryBody = getBody("https://api.hh.ru/areas/countries");
        CountryDTO[] countries = gson.fromJson(countryBody, CountryDTO[].class);

        System.out.println("Список стран:");
        for (CountryDTO o : countries) {
            System.out.println(o.getName());
        }

        System.out.println("---\n---\n---");
        System.out.println("Введите страну:");
        // Метод Objects.requireNonNull ( ... ) проверяет на null
        // Если передаваемое значение равно null, То выходит сообщение об ошибке
        String countryNameIn = Objects.requireNonNull(scanner.nextLine()).toLowerCase();

        RegionsDTO regions = null;
        for (CountryDTO o : countries) {
            if (o.getName().toLowerCase().equals(countryNameIn)) {
                String bodyReg = getBody(o.getUrl());
                regions = gson.fromJson(bodyReg, RegionsDTO.class);
                System.out.println("Список регионов:");
                for (RegionsDTO.AreasBeanX area : regions.getAreas()) {
                    for (RegionsDTO.AreasBeanX.AreasBean areaArea : area.getAreas()) {
                        System.out.println(areaArea.getName());
                    }
                }
            }
        }

        System.out.println("---\n---\n---");
        System.out.println("Введите регион:");
        String regionNameIn = Objects.requireNonNull(scanner.nextLine()).toLowerCase();

        RegionsDTO.AreasBeanX.AreasBean areaArea = null;
        List<RegionsDTO.AreasBeanX> areas = Objects.requireNonNull(regions).getAreas();
        for (RegionsDTO.AreasBeanX area : areas) {
            for (RegionsDTO.AreasBeanX.AreasBean itArea : area.getAreas()) {
                if (itArea.getName().toLowerCase().equals(regionNameIn)) {
                    areaArea = itArea;
                    break;
                }
            }
        }

        if (areaArea == null) {
            System.out.println("Такого региона нет в списке");
            return;
        }
        String regionId = areaArea.getId();
        String vacancyBody = getBody("https://api.hh.ru/vacancies?per_page=100&area=" + regionId);
        VacancyDTO vacancies = gson.fromJson(vacancyBody, VacancyDTO.class);

        List<VacancyDTO.ItemsBean> items = vacancies.getItems();

        double srednZp = 0; // средняя зарплата
        String currency = null;
        for (VacancyDTO.ItemsBean item : items) {
            VacancyDTO.ItemsBean.Salary salary = item.getSalary();

            if (salary == null) continue;
            if (currency == null) currency = salary.getCurrency();

            Integer to = salary.getTo();
            Integer from = salary.getFrom();

            // В вакансиях могут указыватся желаемые ЗП "от", "до" и "от и до"
            if (to == null && from != null) srednZp = srednZp + from; // только "от"
            else if (to != null && from == null) srednZp = srednZp + to; // только "до"
            else if (to != null && from != null) srednZp = srednZp + (to + from) / 2; // "от" и "до"
        }
        srednZp = srednZp / items.size();

        // ***
        // Сохранение в БД
        Db db = new Db("jdbc:postgresql://localhost:5432/my_api",
                "postgres",
                "Tgb23456");
        try {
            db.saveVacancies(vacancies);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ***

        System.out.println("Средняя зарплата: " + srednZp + ' ' + currency + '.');
        System.out.println("Введите путь для сохранения файла отчёта CSV:");
        String savePath = scanner.nextLine();
        saveSCV(vacancies, srednZp, currency, savePath);
    }

    private static String getBody(String urlToRead) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Java/Console");
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );
        while (true) {
            String line = rd.readLine();
            if (line == null) break;
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    private static void saveSCV(VacancyDTO dto, double srednZp, String srednZpCurrency, String savePath) {
        PrintWriter pw;
        File file = new File(savePath + "/result.csv");
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("Некорректно указанный путь для сохранения!");
            return;
        }

        StringBuilder sb = new StringBuilder("Заголовок,от,до,валюта,URL–вакансии\n–\n");

        for (VacancyDTO.ItemsBean item : dto.getItems()) {
            String title = item.getName();

            sb.append(title);
            sb.append(',');

            VacancyDTO.ItemsBean.Salary salary = item.getSalary();
            if (salary != null) {
                Integer to = salary.getTo();
                Integer from = salary.getFrom();
                if (from == null) from = 0;
                if (to == null) to = 0;

                String currency = salary.getCurrency();

                sb.append(from);
                sb.append(',');
                sb.append(to);
                sb.append(',');
                sb.append(currency);
                sb.append(',');
            } else {
                sb.append("—,—,—,");
            }
            sb.append(item.getAlternateUrl());
            sb.append('\n');
        }
        sb.append("\nСредняя зарплата: ");
        sb.append(srednZp);
        sb.append(' ');
        sb.append(srednZpCurrency);
        sb.append('.');
        String resultText = sb.toString();

        pw.write(resultText);
        pw.close();
        System.out.println("Сохранён CSV по следующему пути:");
        System.out.println(file.getAbsolutePath());
    }

}
