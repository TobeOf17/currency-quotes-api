package com.kuko.currency_quotes_api;

import static org.junit.jupiter.api.Assertions.*;

import com.kuko.currency_quotes_api.model.Quote;
import com.kuko.currency_quotes_api.service.QuoteService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class QuoteServiceTest {

  private final QuoteService service = new QuoteService();

  @Test
  void returnsQuoteWhenPairExists() {
    Quote quote = service.getQuote("USD/NGN");
    assertNotNull(quote);
    assertEquals("USD/NGN", quote.getPair());
    assertEquals(new BigDecimal("1522.66"), quote.getPrice());
  }

  @Test
  void returnsNullWhenPairDoesNotExist() {
    Quote quote = service.getQuote("FAKE/PAIR");
    assertNull(quote);
  }
}
