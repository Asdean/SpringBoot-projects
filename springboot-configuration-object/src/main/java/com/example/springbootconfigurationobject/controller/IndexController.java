package com.example.springbootconfigurationobject.controller;

import com.example.springbootconfigurationobject.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private User user;

    @RequestMapping("/say")
    public @ResponseBody String say() {
        return "user.name:" + user.getName()+ " user.age:" + user.getAge();
    }
}
