package com.example.contract_stub_runner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureWireMock(port = 0)
@AutoConfigureMockMvc
//@TestPropertySource(properties = "feign.test.url=http://localhost:${wiremock.server.port}")
public class TestControllerIntegrationTest {

//  @Value("${wiremock.server.port}")
//  private int wireMockPort;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void test() throws Exception {
    WireMock.stubFor(WireMock.get(urlEqualTo("/remote/test"))
        .willReturn(aResponse()
            .withStatus(200)
            .withBody("Mocked Response")));


    mockMvc.perform(get("/test")).andExpect(status().isOk());
  }
}
