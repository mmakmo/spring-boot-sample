package com.example.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.domain.entity.ShopItemEntity;

import java.util.List;

@ConfigAutowireable
@Dao
public interface ShopItemsRepository {

@Select
List<ShopItemEntity> getShopItems(final Integer shopId);

}