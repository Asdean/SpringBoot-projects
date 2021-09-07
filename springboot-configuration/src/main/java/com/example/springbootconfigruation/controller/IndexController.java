package com.example.springbootconfigruation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    // 获取配置文件中自定义的配置项的值
    @Value("${theusername}")
    private String username;

    @Value("${age}")
    private Integer age;

    @RequestMapping("/say")
    public @ResponseBody String say() {
        return "hello " + username + " age:" + age;
    }
}
