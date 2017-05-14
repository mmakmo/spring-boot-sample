create schema if not exists "public";

create table shops (
	shop_id int(5) not null,
	shop_name varchar(255) not null
);
alter table shops add constraint shops_pk primary key(shop_id);

create table items (
	shop_id int(5) not null,
	item_id int(5) not null,
	item_name varchar(255) not null
);
alter table items add constraint items_pk primary key(shop_id, item_id);