package com.example.contract_stub_runner.controller;

import com.example.contract_stub_runner.remote.TestFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  private final TestFeignClient feignClient;

  public TestController(TestFeignClient feignClient) {
    this.feignClient = feignClient;
  }

  @GetMapping("/test")
  public String test() {
    return feignClient.test();
  }
}
