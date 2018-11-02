package com.example;

import com.example.obj.vacancy.VacancyDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Db {
    private String url, username, password;

    public Db(String url, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void saveVacancies(VacancyDTO dto) throws SQLException {
        Connection connection = getConnection();
        String sql = "insert into vacancies (title, zp_from, zp_to, zp_currency, url) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (VacancyDTO.ItemsBean item : dto.getItems()) {
            String title = item.getName();


            String vacancyUrl = item.getAlternateUrl();

            preparedStatement.setString(1, title);
            preparedStatement.setString(5, vacancyUrl);

            VacancyDTO.ItemsBean.Salary salary = item.getSalary();
            if (salary != null) {
                Integer to = salary.getTo();
                Integer from = salary.getFrom();

                if (to == null) to = 0;
                if (from == null) from = 0;
                String currency = salary.getCurrency();

                preparedStatement.setInt(2, from);
                preparedStatement.setInt(3, to);
                preparedStatement.setString(4, currency);
                preparedStatement.execute();
            } else {
                preparedStatement.setInt(2, 0);
                preparedStatement.setInt(3, 0);
                preparedStatement.setString(4, null);
            }
        }
    }

}
