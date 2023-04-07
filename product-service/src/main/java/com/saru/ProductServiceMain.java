package com.saru;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Product Service",
                version = "1.0",
                description = "Contains all the APIs of Product Service"))
public class ProductServiceMain {
    public static void main(String[] args) {

        System.out.println(SpringApplication.run(ProductServiceMain.class,args));
    }
}