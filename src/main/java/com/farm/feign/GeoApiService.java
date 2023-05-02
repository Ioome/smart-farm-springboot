package com.farm.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @name: LocationApiService
 * @author: sutton
 * @date: 2023-05-02 15:40
 * @description: LocationApiService
 */

@FeignClient(name = "geo-api", url = "https://geoapi.qweather.com/v2")
public interface GeoApiService {

    @GetMapping("/city/lookup")
    String lookupCity (@RequestParam("location") String location, @RequestParam("key") String key);
}
