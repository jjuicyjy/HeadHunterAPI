create table vacancies(
  id serial not null constraint vacancies_pkey primary key,
  title varchar(180) not null,
  zp_from bigint,
  zp_to bigint,
  zp_currency varchar(6),
  url varchar(255) not null,
  save_date integer
);
alter table vacancies owner to postgres;
create unique index vacancies_id_uindex on vacancies (id);