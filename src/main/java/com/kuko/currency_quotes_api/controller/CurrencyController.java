package com.kuko.currency_quotes_api.controller;

import com.kuko.currency_quotes_api.model.Quote;
import com.kuko.currency_quotes_api.service.QuoteService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

  private final QuoteService quoteService;

  public CurrencyController(QuoteService quoteService) {
    this.quoteService = quoteService;
  }

  // Get any currency pair quote
  @GetMapping("/quote/{pair}")
  public Quote getQuote(@PathVariable String pair) {
    return quoteService.getQuote(pair);
  }

  // Get all major currencies to Naira rates
  @GetMapping("/naira/rates")
  public List<Quote> getAllNairaRates() {
    return List.of(
        quoteService.getQuote("USD/NGN"),
        quoteService.getQuote("EUR/NGN"),
        quoteService.getQuote("GBP/NGN"),
        quoteService.getQuote("JPY/NGN"),
        quoteService.getQuote("CAD/NGN"),
        quoteService.getQuote("AUD/NGN"));
  }

  // Get Naira to all major currencies
  @GetMapping("/naira/convert")
  public List<Quote> getNairaConversions() {
    return List.of(
        quoteService.getQuote("NGN/USD"),
        quoteService.getQuote("NGN/EUR"),
        quoteService.getQuote("NGN/GBP"),
        quoteService.getQuote("NGN/JPY"),
        quoteService.getQuote("NGN/CAD"),
        quoteService.getQuote("NGN/AUD"));
  }
}
