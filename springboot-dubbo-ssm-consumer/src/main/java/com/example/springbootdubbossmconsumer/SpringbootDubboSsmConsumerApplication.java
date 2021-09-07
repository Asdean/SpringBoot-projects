package com.example.springbootdubbossmconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class SpringbootDubboSsmConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboSsmConsumerApplication.class, args);
    }

}
