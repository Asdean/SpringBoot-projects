package com.example.springbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/say")
    public ModelAndView say() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "hello springboot");
        mv.setViewName("say");
        return mv;
    }

    @RequestMapping("/say2")
    public String say2(Model model) {
        model.addAttribute("message", "hello world");
        return "say";
    }
}
