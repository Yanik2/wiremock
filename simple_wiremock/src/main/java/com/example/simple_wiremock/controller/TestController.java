package com.example.simple_wiremock.controller;

import com.example.simple_wiremock.client.TestFeignClient;
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
