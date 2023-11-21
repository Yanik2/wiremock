package com.example.simple_wiremock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimpleWiremockApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimpleWiremockApplication.class, args);
  }

}
