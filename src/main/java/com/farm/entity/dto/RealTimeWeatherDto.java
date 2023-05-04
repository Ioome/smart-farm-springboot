package com.farm.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RealTimeWeatherDto {

    private String code;
    private Date updateTime;
    private Now now;}