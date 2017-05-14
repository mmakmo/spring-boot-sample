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

insert into shops (shop_id, shop_name) values (1, 'shop 1');
insert into shops (shop_id, shop_name) values (2, 'shop 2');
insert into shops (shop_id, shop_name) values (3, 'shop 3');

insert into items (shop_id, item_id, item_name) values(1, 1, 'shop1 item1');
insert into items (shop_id, item_id, item_name) values(1, 2, 'shop1 item2');
insert into items (shop_id, item_id, item_name) values(1, 3, 'shop1 item3');
insert into items (shop_id, item_id, item_name) values(2, 1, 'shop2 item1');
insert into items (shop_id, item_id, item_name) values(2, 2, 'shop2 item2');
insert into items (shop_id, item_id, item_name) values(2, 3, 'shop2 item3');
insert into items (shop_id, item_id, item_name) values(3, 1, 'shop3 item1');
insert into items (shop_id, item_id, item_name) values(3, 2, 'shop3 item2');
insert into items (shop_id, item_id, item_name) values(3, 3, 'shop3 item3');
