package com.lsh.Controller;

import com.lsh.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by houbank on 2018/4/25.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {


    @Autowired
    private RedisService redisService;

    @RequestMapping("/getRedisValue")
    public String getReidsValue(String key){
        return redisService.get(key).toString();
    }


    @RequestMapping("/setRedisValue")
    public void setRedisValue(String key,String value){
        redisService.set(key,value);
    }
}
