package com.example.springbootwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class ChatController {

    private AtomicInteger idProducer = new AtomicInteger();

    @RequestMapping("/")
    // / 访问路径
    // http://localhost:8080// 正常访问
    // http://localhost:8080/ 弹出下载界面
    public String index(Model model) {
        model.addAttribute("username","user" + idProducer.getAndIncrement());
        return "index";
    }
}
