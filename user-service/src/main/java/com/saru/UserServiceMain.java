package com.saru;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "User Service",
                version = "1.0",
                description = "Contains all the APIs of User Service"))
public class UserServiceMain {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(UserServiceMain.class,args));
    }
}