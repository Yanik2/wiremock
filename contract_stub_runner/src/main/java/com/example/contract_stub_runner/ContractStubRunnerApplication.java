package com.example.contract_stub_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContractStubRunnerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ContractStubRunnerApplication.class, args);
  }

}
