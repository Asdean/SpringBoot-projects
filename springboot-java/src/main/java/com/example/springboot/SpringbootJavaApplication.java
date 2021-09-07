package com.example.springboot;

import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// 方法二，实现CommandLineRunner，重写run方法
public class SpringbootJavaApplication implements CommandLineRunner {


    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJavaApplication.class, args);

        /*
        关闭启动logo
        SpringApplication springApplication = new SpringApplication(SpringbootJavaApplication.class, args);

        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
        */

        /*
        spring boot创建非web工程 方法一
        // SpringApplication.run(SpringbootJavaApplication.class, args);
        *//**
         * Springboot程序启动后,返回值是ConfigurableApplicationContext,它也是一个Spring容器
         * 它其实相当于原来Spring容器中启动容器ClasspathXmlApplicationContext
         *//*
        //获取Springboot容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootJavaApplication.class, args);

        //从spring容器中获取指定bean对象
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");

        //调用业务方法
        String sayHello = studentService.sayHello();

        System.out.println(sayHello);
        */
    }

    @Override
    public void run(String... args) throws Exception {
        //调用业务方法
        String sayHello = studentService.sayHello();

        System.out.println(sayHello);
    }
}
