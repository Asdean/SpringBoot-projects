package com.example.springbootswagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2 // 开启Swagger2的支持
@Configuration // 配置类，== applicationContext.xml
public class SwaggerConfig {
    /**
     * 在spring容器配置一个bean对象
     *
     * @Bean等价于 <bean id="createRestApi" class="xxxx.Docket">
     *
     * @return
     */
    @Bean
    public Docket docket() {
        // 链式编程（构建器模式），基本是固定；
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)//可以开启或关闭swagger文档
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.example.springbootswagger.controller"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//扫描有ApiOperation注解的方法
                //.paths(PathSelectors.any())
                .paths((s) -> !s.contains("/login")) //不包含login登录的路径
                .build();
    }

    /**
     * 创建api的基本信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        // 链式编程（构建器模式），基本是固定；
        return new ApiInfoBuilder()
                .title("用户账号中心接口文档")
                .description("集成Swagger2构建RESTful APIs")
                .termsOfServiceUrl("com.example.springbootswagger")
                .contact(new Contact("test","com.example.springbootswagger","email.com"))
                .license("采用 Apache 2.0 开源许可证")
                .licenseUrl("。。。")
                .version("1.0.0")
                .build();
    }
}