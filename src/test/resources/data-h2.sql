insert into country (country_id, country, last_update) values (1, 'Austria', now());
insert into country (country_id, country, last_update) values (2, 'Germany', now());

insert into city (city_id, country_id, city, last_update) values (1, 1, 'Wien', now());
insert into city (city_id, country_id, city, last_update) values (2, 1, 'Linz', now());
insert into city (city_id, country_id, city, last_update) values (3, 2, 'Linz', now());

insert into address (address_id, city_id, address, address2, district, postal_code, phone, last_update) values (1, 1, 'Kärtnerstr. 1', '', 'Wien', '1010', '1234567', now());
insert into address (address_id, city_id, address, address2, district, postal_code, phone, last_update) values (2, 1, 'Währingerstr. 34', '', 'Wien', '1090', '2355535', now());
insert into address (address_id, city_id, address, address2, district, postal_code, phone, last_update) values (3, 2, 'Ferihumerstr. 21', '', 'Linz', '4040', '6565587', now());
insert into address (address_id, city_id, address, address2, district, postal_code, phone, last_update) values (4, 2, 'Hauptstr. 54', '', 'Linz', '4040', '6565587', now());

insert into customer (customer_id, address_id, first_name, last_name, email, activebool, store_id, create_date, last_update) values (1, 1, 'Hugo', 'TheBoss Sr.', 'email1@hugo.boss', 'true', 1, now(), now());
insert into customer (customer_id, address_id, first_name, last_name, email, activebool, store_id, create_date, last_update) values (2, 1, 'Hugo', 'TheBoss Jr.', 'email2@hugo.boss', 'true', 1, now(), now());
insert into customer (customer_id, address_id, first_name, last_name, email, activebool, store_id, create_date, last_update) values (3, 2, 'Huber', 'Mayr', 'email3@hugo.boss', 'true', 1, now(), now());
insert into customer (customer_id, address_id, first_name, last_name, email, activebool, store_id, create_date, last_update) values (4, 2, 'Gilbert', 'Mayr', 'email4@hugo.boss', 'true', 1, now(), now());
insert into customer (customer_id, address_id, first_name, last_name, email, activebool, store_id, create_date, last_update) values (5, 2, 'Franz', 'Mayr', 'email5@hugo.boss', 'true', 2, now(), now());
insert into customer (customer_id, address_id, first_name, last_name, email, activebool, store_id, create_date, last_update) values (6, 3, 'Mike', 'Mustermann', 'email6@hugo.boss', 'true', 2, now(), now());