package com.example.controller;

import com.example.domain.model.ShopItem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import com.example.domain.service.ShopItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Map;


@Api(tags = { "Shop Items API" })
@RequestMapping("/api/v1/shop-items")
@RestController
@EnableAutoConfiguration
public class ShopItemsController {

    @Autowired
    ShopItemsService shopItemsService;

    @ApiOperation(
        value = "Get selected shop's items",
        notes = "Get selected shop's items.",
        response = ShopItem.class,
        responseContainer = "List"
    )
    @RequestMapping(value = "/{shopId}/items", method = RequestMethod.GET)
    @ApiImplicitParams ({
        @ApiImplicitParam (name = "shopId", value = "shopId", required = true, dataType = "int", paramType = "path", defaultValue="2", allowableValues = "range[1,99999]"),
      })
    @ResponseBody
    public List<ShopItem> getShopItems(
        @ApiIgnore @PathVariable Integer shopId
    ){
        return shopItemsService.getShopItems(shopId);
    }

    @ApiImplicitParams ({
        @ApiImplicitParam (name = "shopId", value = "ID", required = false, dataType = "int", paramType = "path", defaultValue="2", allowableValues = "range[1,2]"),
        @ApiImplicitParam (name = "bool", value = "Boolean", required = true, dataType = "boolean", paramType = "query", defaultValue="false", allowableValues = "true, false"),
        @ApiImplicitParam (name = "filters", value = "Filtering", required = true, allowMultiple = true, dataType = "string", paramType = "query", defaultValue="no-filter", allowableValues = "no-filter, is-open, has-online-store")
      })
    @RequestMapping(value = "/shop-info/{shopId}", method = RequestMethod.GET)
    @ResponseBody
    public String getShopInfo(
        @ApiIgnore @PathVariable(value="shopId") Integer shopId,
        @ApiIgnore @RequestParam(value="bool") Boolean bool,
        @ApiIgnore @RequestParam(value="filters") List<String> filters
    ){
        return shopItemsService.getShopInfo(shopId, bool, filters);
    }
}