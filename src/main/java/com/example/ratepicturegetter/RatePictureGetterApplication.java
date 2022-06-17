package com.example.ratepicturegetter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RatePictureGetterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatePictureGetterApplication.class, args);
    }

}
