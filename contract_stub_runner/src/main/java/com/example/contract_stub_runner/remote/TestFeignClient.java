package com.example.contract_stub_runner.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "testClient", url = "${feign.test.url}")
public interface TestFeignClient {

  @GetMapping("/remote/test")
  String test();
}
