package com.farm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @name: RestTemplateConfig
 * @author: sutton
 * @date: 2023-05-03 20:23
 * @description: RestTemplateConfig
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate customRestTemplate () {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(3000);
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(3000);
        return new RestTemplate(httpRequestFactory);
    }
}
