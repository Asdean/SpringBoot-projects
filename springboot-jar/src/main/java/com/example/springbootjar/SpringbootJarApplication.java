package com.example.springbootjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 打包jar不需实现SpringBootServletInitializer类
public class SpringbootJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJarApplication.class, args);
    }

}
