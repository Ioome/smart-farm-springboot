package com.farm.entity.po;

import lombok.Data;

import java.util.List;


@Data
public class WeatherData {
    private String code;
    private String updateTime;
    private String fxLink;
    private List<DailyWeatherData> daily;
    private Refer refer;

    // getters and setters


    @Data
    public static class DailyWeatherData {
        private String fxDate;
        private String tempMax;
        private String tempMin;
        private String iconDay;
        private String iconNight;
        private String textDay;
        private String textNight;
        private String wind360Day;
        private String windDirDay;
        private String windScaleDay;
        private String windSpeedDay;
        private String wind360Night;
        private String windDirNight;
        private String windScaleNight;
        private String windSpeedNight;
        private String humidity;
        private String precip;
        private String pressure;
    }


    @Data
    public static class Refer {
        private List<String> sources;
        private List<String> license;

        // getters and setters
    }
}