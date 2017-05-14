package com.example.domain.entity;

import java.io.Serializable;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class ShopItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    public Integer shopId;

    public String shopName;

    @Id
    public Integer itemId;

    public String itemName;


}