package com.wh.bling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlingApplication.class, args);
    }

}
