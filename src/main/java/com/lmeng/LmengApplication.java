package com.lmeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

//@Configuration
//@SuppressWarnings("ALL")
@MapperScan(basePackages = "com.lmeng.mapper")
@SpringBootApplication//扫描 mybatis mapper 包路径
public class LmengApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmengApplication.class, args);
    }
}
