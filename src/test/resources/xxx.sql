create table "country" (
    id int not null,
    country varchar(255) not null,
    primary key (id)
);

create table "city" (
    id int not null,
    city varchar(255) not null,
    country_id int not null,
    primary key (id)
);

alter table "city" add constraint fkCountry foreign key (country_id) references "country" (id);

create table "address" (
    id int not null,
    address varchar(255) not null,
    city_id int not null,
    primary key (id)
);

alter table "address" add constraint fkCity foreign key (city_id) references "city" (id);

create table "customer" (
    id int not null,
    name varchar(255) not null,
    address_id int not null,
    primary key (id)
);

alter table "customer" add constraint fkAddress foreign key (address_id) references "address" (id);