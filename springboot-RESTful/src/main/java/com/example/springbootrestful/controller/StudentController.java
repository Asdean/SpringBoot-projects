package com.example.springbootrestful.controller;

import com.example.springbootrestful.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class StudentController {


    @RequestMapping(value = "/student")
    public Object student(Integer id,Integer age) {
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        return student;
    }

    // @RequestMapping(value = "/student/detail/{id}/{age}")
    @GetMapping(value = "/student/detail/{id}/{age}")
    public Object student1(@PathVariable("id") Integer id,
                           @PathVariable("age") Integer age) {
        Map<String,Object> retMap = new HashMap<>();

        retMap.put("id",id);
        retMap.put("age",age);
        return retMap;
    }

    // @RequestMapping(value = "/student/detail/{id}/{status}")
    @DeleteMapping(value = "/student/detail/{id}/{status}")
    public Object student2(@PathVariable("id") Integer id,
                           @PathVariable("status") Integer status) {
        Map<String,Object> retMap = new HashMap<>();

        retMap.put("id",id);
        retMap.put("status",status);
        return retMap;
    }

    // 以上代码student1和student2会出现请求路径冲突问题
    // 通常在RESTful风格中方法的请求方式会按增删改查的请求方式来区分
    // 修改请求路径
    // RESUful请求风格要求路径中使用的单词都是名称,最好不要出现动词

    @DeleteMapping(value = "/student/{id}/detail/{city}")
    public Object student3(@PathVariable("id") Integer id,
                           @PathVariable("city") Integer city) {
        Map<String,Object> retMap = new HashMap<>();

        retMap.put("id",id);
        retMap.put("city",city);
        return retMap;
    }

    @PostMapping(value = "/student/{id}")
    public String addStudent(@PathVariable("id") Integer id) {
        return "add student ID:" + id;
    }

    @PutMapping(value = "/student/{id}")
    public String updateStudent(@PathVariable("id") Integer id) {
        return "update Student ID:" + id;
    }
}
