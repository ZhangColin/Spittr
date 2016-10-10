package com.cartisan.spittr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2016/10/9.
 */
@ComponentScan
@EnableAutoConfiguration(exclude = MustacheAutoConfiguration.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
