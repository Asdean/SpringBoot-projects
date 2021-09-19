package com.example.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 声明mapper包为mapper接口, 无需在mapper类上加注解@Mapper
// @MapperScan(basePackages = "com.example.springbootmybatis.mapper")
// @EnableTransactionManagement    //开启事务(可选项)
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
