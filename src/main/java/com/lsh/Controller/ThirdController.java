package com.lsh.Controller;

import com.lsh.service.ThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by houbank on 2018/4/23.
 */
@RestController
@RequestMapping("/third")
public class ThirdController {

    @Autowired
    private ThirdService thirdService;

    @RequestMapping("/getTianQi")
    public Map<String,Object> getTianQi(){
        String url = "https://www.sojson.com/open/api/weather/json.shtml?city=北京";
        return  thirdService.getTianqi(url);
    }
}
