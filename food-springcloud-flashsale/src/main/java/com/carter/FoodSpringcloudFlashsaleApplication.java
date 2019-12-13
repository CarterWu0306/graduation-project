package com.carter;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@EnableDistributedTransaction
@SpringBootApplication
@MapperScan("com.carter.mapper")
public class FoodSpringcloudFlashsaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodSpringcloudFlashsaleApplication.class, args);
    }

}
