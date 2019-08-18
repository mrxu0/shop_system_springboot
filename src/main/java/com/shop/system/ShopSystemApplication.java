package com.shop.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shop.system.mapper")
public class ShopSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSystemApplication.class, args);
    }

}
