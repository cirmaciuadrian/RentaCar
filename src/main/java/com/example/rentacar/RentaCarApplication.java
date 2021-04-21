package com.example.rentacar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@SpringBootApplication
public class RentaCarApplication {

    @RequestMapping("/home")
    public String home() {
        return "Hello World!!!";
    }


    public static void main(String[] args) {
        SpringApplication.run(RentaCarApplication.class, args);
    }

}
