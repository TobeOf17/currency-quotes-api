package com.kuko.currency_quotes_api.service;

import com.kuko.currency_quotes_api.model.Quote;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

  // Current exchange rates as of September 2025
  private final Map<String, BigDecimal> currentRates =
      Map.ofEntries(
          // Major currencies to NGN
          Map.entry("USD/NGN", new BigDecimal("1522.66")),
          Map.entry("EUR/NGN", new BigDecimal("1787.63")),
          Map.entry("GBP/NGN", new BigDecimal("1950.00")),
          Map.entry("JPY/NGN", new BigDecimal("10.50")),
          Map.entry("CAD/NGN", new BigDecimal("1120.00")),
          Map.entry("AUD/NGN", new BigDecimal("1015.00")),

          // NGN to major currencies
          Map.entry("NGN/USD", new BigDecimal("0.000657")),
          Map.entry("NGN/EUR", new BigDecimal("0.000559")),
          Map.entry("NGN/GBP", new BigDecimal("0.000513")),
          Map.entry("NGN/JPY", new BigDecimal("0.095")),
          Map.entry("NGN/CAD", new BigDecimal("0.000893")),
          Map.entry("NGN/AUD", new BigDecimal("0.000985")));

  public Quote getQuote(String pair) {
    BigDecimal rate = currentRates.get(pair);
    if (rate == null) {
      return null; // or throw new RuntimeException("Currency pair not found: " + pair);
    }
    return new Quote(pair, rate);
  }
}
