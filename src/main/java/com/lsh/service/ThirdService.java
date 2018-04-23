package com.lsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 调用第三方服务
 * Created by houbank on 2018/4/23.
 */
@Service
public class ThirdService {

    @Autowired
    private  RestTemplate restTemplate;

    public Map<String,Object> getTianqi(String url){
        Map<String,Object> map = restTemplate.getForObject(url,Map.class);
        return map;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
}
