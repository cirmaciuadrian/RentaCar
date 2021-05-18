package com.example.rentacar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

@SpringBootApplication
public class RentaCarApplication {

    @RequestMapping("/")
    void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/home");
    }



    public static void main(String[] args) {
        SpringApplication.run(RentaCarApplication.class, args);
    }

}
