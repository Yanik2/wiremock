package com.example.simple_wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import com.maciejwalkowiak.wiremock.spring.InjectWireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@EnableWireMock(
    {@ConfigureWireMock(name = "feignTest", property = "feign.test.url")}
)
@AutoConfigureMockMvc
public class TestControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @InjectWireMock("feignTest")
  private WireMockServer wiremock;

  @Test
  void test() throws Exception {
    wiremock.stubFor(get(urlEqualTo("/remote/test"))
        .willReturn(aResponse().withBody("response body")));

    mockMvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(status().isOk());

  }
}
