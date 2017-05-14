-- getShopItems.sql

select
    item.shop_id as shopId,
    shop.shop_name as shopName,
    item.item_id as itemId,
    item.item_name as itemName
from
    shops shop
inner join
    items item
    on shop.shop_id = item.shop_id
where
    shop.shop_id = /* shopId */1