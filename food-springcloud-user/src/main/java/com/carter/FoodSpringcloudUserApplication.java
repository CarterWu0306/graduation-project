package com.carter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.carter.mapper")
public class FoodSpringcloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodSpringcloudUserApplication.class, args);
    }

}
