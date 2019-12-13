package com.carter;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableDistributedTransaction
@SpringBootApplication
@EnableHystrix
@EnableFeignClients
@MapperScan("com.carter.mapper")
public class FoodSpringcloudFlashsaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodSpringcloudFlashsaleApplication.class, args);
    }

}
