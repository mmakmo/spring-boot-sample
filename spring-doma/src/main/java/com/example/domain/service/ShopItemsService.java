package com.example.domain.service;

import com.example.domain.model.ShopItem;
import com.example.domain.entity.ShopItemEntity;
import com.example.domain.repository.ShopItemsRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopItemsService {

    @Autowired
    ShopItemsRepository shopItemRepository;

    public List<ShopItem> getShopItems(Integer shopId) {
        return shopItemRepository.getShopItems(shopId)
            .stream()
            .map(item -> getShopItemModel(item))
            .collect(Collectors.toList());
    }

    public String getShopInfo(
        Integer shopId,
        Boolean bool,
        List<String> filters
    ) {
        String value = "";
        for (String filter : filters) {
            value += "(" + filter + ")";
        }
        if (bool) {
            return "shop ID: " + shopId + " and Filters: " + value;
        }
        return "Don't show you!'";
    }


    private ShopItem getShopItemModel(ShopItemEntity item) {
        ShopItem shopItemModel = new ShopItem();
        shopItemModel.shopId = item.shopId;
        shopItemModel.shopName = item.shopName;
        shopItemModel.itemId = item.itemId;
        shopItemModel.itemName = item.itemName;
        return shopItemModel;
    }

}