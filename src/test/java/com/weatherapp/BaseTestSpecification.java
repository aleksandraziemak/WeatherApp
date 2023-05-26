package com.weatherapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@ActiveProfiles("e2e")
@SpringBootTest
@AutoConfigureMockMvc
public class BaseTestSpecification {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public MockRestServiceServer mockServer;

    protected BigDecimal formatBigDecimal(BigDecimal value) {
        return value.setScale(2, RoundingMode.CEILING);
    }
}
