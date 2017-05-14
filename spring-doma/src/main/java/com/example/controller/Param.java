package com.example.controller;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "社員情報")
public class Param implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", required=true)
    public Integer id;

    @ApiModelProperty(value = "name", required=true)
    public String name;

}