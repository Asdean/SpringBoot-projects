package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.model.User;
import com.example.springbootthymeleaf.model.User1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class UserController {
    @RequestMapping("/message")
    public String message(Model model) {
        model.addAttribute("data", "集成thymeleaf模板引擎");
        return "message";
    }

    @RequestMapping("/user/detail")
    public String userDetail(Model model) {
        User user = new User();
        user.setId(1001);
        user.setUsername("zhangsan");
        user.setAge(20);

        model.addAttribute("user", user);
        return "userDetail";
    }

    @RequestMapping(value = "/url")
    public String urlExpression(Model model) {

        model.addAttribute("id",1001);
        model.addAttribute("age",28);
        model.addAttribute("username","zhaoliu");

        return "url";
    }


    @RequestMapping(value = "/test")
    public @ResponseBody String test(String username) {
        return "请求路径/test,参数是:" + username;
    }

    @RequestMapping(value = "/test1")
    public @ResponseBody String test1(Integer id,String username,Integer age) {
        return "请求路径/test1,参数id=" + id+",username="+username+",age="+age;
    }

    @RequestMapping(value = "/test2/{id}")
    public @ResponseBody String test2(@PathVariable("id") Integer id) {
        return "ID="+id;
    }

    @RequestMapping(value = "/test3/{id}/{username}")
    public @ResponseBody String test3(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username) {
        return "ID="+id+"----username="+username;
    }

    @RequestMapping(value = "/url2")
    public String url2() {
        return "url2";
    }

    @RequestMapping(value = "/property")
    public String property() {
        return "property";
    }


    // each
    @RequestMapping("/each/list")
    public String eachList(Model model) {
        List<User1> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User1 user = new User1();
            user.setId(100 + i);
            user.setNick("张" + i);
            user.setPhone("1361234567" + i);
            user.setAddress("北京市大兴区" + i);
            userList.add(user);
        }
        model.addAttribute("userList", userList);
        return "eachList";
    }

    @RequestMapping(value = "/each/map")
    public String eachMap(Model model) {
        Map<Integer, Object> userMaps = new HashMap<Integer, Object>();

        for (int i = 0; i < 10; i++) {
            User1 user = new User1();
            user.setId(i);
            user.setNick("李四" + i);
            user.setPhone("1390000000" + i);
            user.setAddress("天津市" + i);
            userMaps.put(i, user);
        }
        model.addAttribute("userMaps", userMaps);
        return "eachMap";
    }

    @RequestMapping(value = "/each/array")
    public String eachArray(Model model) {

        User1[] userArray = new User1[10];

        for (int i = 0; i < 10; i++) {

            User1 user = new User1();
            user.setId(i);
            user.setNick("赵六" + i);
            user.setPhone("1380000000" + i);
            user.setAddress("深圳市" + i);
            userArray[i] = user;

        }
        model.addAttribute("userArray", userArray);
        return "eachArray";
    }

    @RequestMapping(value = "/each/all")
    public String eachAll(Model model) {
        //list -> Map -> List -> User
        List<Map<Integer, List<User1>>> myList = new ArrayList<Map<Integer, List<User1>>>();

        for (int i = 0; i < 2; i++) {

            Map<Integer, List<User1>> myMap = new HashMap<Integer, List<User1>>();
            for (int j = 0; j < 2; j++) {
                List<User1> myUserList = new ArrayList<User1>();
                for (int k = 0; k < 3; k++) {
                    User1 user = new User1();
                    user.setId(k);
                    user.setNick("张三" + k);
                    user.setPhone("1350000000" + k);
                    user.setAddress("广州市" + i);
                    myUserList.add(user);
                }
                myMap.put(j, myUserList);
            }
            myList.add(myMap);

        }
        model.addAttribute("myList", myList);
        return "eachAll";
    }


    // if
    @RequestMapping(value = "/condition")
    public String condition(Model model) {

        model.addAttribute("sex",1);

        model.addAttribute("flag",true);

        model.addAttribute("productType",0);

        return "condition";
    }

    // 内敛文本或脚本
    @RequestMapping(value = "/inline")
    public String inline(Model model) {
        model.addAttribute("data","SpringBoot inline");
        return "inline-test";
    }


    // 字面量
    @RequestMapping(value = "/literal")
    public String literal(Model model) {

        model.addAttribute("sex",1);
        model.addAttribute("data","SpringBoot Data");
        model.addAttribute("flag",true);

        User user = new User();
        user.setId(1001);
        user.setUsername("lisi");
        user.setAge(20);
        model.addAttribute("user",user);

        User userDetail = new User();
        model.addAttribute("userDetail",userDetail);

        return "literal";
    }

    // 字符串拼接
    @RequestMapping(value = "/splice")
    public String splice(Model model) {
        model.addAttribute("totalRows",123);
        model.addAttribute("totalPage",13);
        model.addAttribute("currentPage",2);

        return "splice";
    }


    // 运算符
    @RequestMapping(value = "/operator")
    public String operator(Model model) {
        model.addAttribute("sex",1);
        model.addAttribute("flag",true);
        return "operator";
    }


    // thymeleaf内置对象
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model, Integer id) {
        model.addAttribute("username","lisi");

        request.getSession().setAttribute("data","sessionData");

        return "index";
    }


    // 内置功能对象 日期,日历,数字,对象等操作方法
    @RequestMapping(value = "/function")
    public String function(Model model) {

        model.addAttribute("date",new Date());
        model.addAttribute("data","SpringBootHelloWorld");
        return "function";
    }
}
