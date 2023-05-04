/**
  * Copyright 2023 json.cn 
  */
package com.farm.entity.dto;
import lombok.Data;

import java.util.Date;
@Data
public class Now {

    private Date obsTime;
    private String temp;
    private String feelsLike;
    private String icon;
    private String text;
    private String wind360;
    private String windDir;
    private String windScale;
    private String windSpeed;
    private String humidity;
    private String precip;
    private String pressure;
    private String vis;
    private String cloud;
    private String dew;

}