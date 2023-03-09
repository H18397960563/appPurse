package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tk.dao")
@SpringBootApplication
public class purseApplication {
    public static void main(String[] args) {
        SpringApplication.run(purseApplication.class,args);
    }
}
