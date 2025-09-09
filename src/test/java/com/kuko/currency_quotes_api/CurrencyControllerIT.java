package com.kuko.currency_quotes_api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyControllerIT {

  @Autowired private MockMvc mockMvc;

  @Test
  void postQuoteTest() throws Exception {
    mockMvc
        .perform(
            post("/api/v1/quote")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"pair\":\"USDNGN\",\"price\":1600.50}"))
        .andExpect(status().isCreated());
  }

  @Test
  void getQuoteTest() throws Exception {
    mockMvc
        .perform(get("/api/v1/quote").param("pair", "USD/NGN"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.pair").value("USD/NGN"));
  }
}
