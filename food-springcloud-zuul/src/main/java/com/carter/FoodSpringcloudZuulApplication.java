package com.carter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class FoodSpringcloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodSpringcloudZuulApplication.class, args);
    }

}
