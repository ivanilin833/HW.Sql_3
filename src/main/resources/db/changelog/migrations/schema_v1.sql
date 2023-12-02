-- changeset ilin:1

create table netology.customers
(
    id           smallserial,
    name         varchar(10),
    surname      varchar(15),
    age          smallint,
    phone_number varchar(11),
    primary key (id)
);
--rollback drop table netology.customers

-- changeset ilin:2

create table netology.orders
(
    id           smallserial primary key,
    date         date,
    customer_id  smallint,
    product_name varchar(20),
    amount       money,
    constraint fk_order
        foreign key (customer_id)
            references netology.customers (id)
);
--rollback drop table netology.orders

-- changeset ilin:3

insert into netology.customers (name, surname, age, phone_number)
values ('ivan', 'ivanov', 11, '89811089566');

insert into netology.customers (name, surname, age, phone_number)
values ('petr', 'ivanov', 11, '89811089566');

insert into netology.customers (name, surname, age, phone_number)
values ('andre', 'ivanov', 11, '89811089566');

insert into netology.customers (name, surname, age, phone_number)
values ('max', 'ivanov', 11, '89811089566');

insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 1, 'phone', 1000);

insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 4, 'book', 5000);

insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 2, 'circle', 500);

insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 3, 'macbook', 10000);