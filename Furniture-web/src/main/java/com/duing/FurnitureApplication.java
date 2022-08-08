package com.duing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.duing", "com.duing.login", "com.duing.backstage", "com.duing.showFurniture"})
@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy
public class FurnitureApplication {
    public static void main(String[] args) {
        SpringApplication.run(FurnitureApplication.class, args);
    }
}

