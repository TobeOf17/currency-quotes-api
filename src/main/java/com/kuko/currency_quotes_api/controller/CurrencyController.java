package com.kuko.currency_quotes_api.controller;

import com.kuko.currency_quotes_api.model.Quote;
import com.kuko.currency_quotes_api.service.QuoteService;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

    private final QuoteService quoteService;

    public CurrencyController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    // POST endpoint
    @PostMapping("/quote")
    public ResponseEntity<Quote> createQuote(@RequestBody Quote request) {
        Quote saved = new Quote(request.getPair(), request.getPrice(), Instant.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @GetMapping("/quote")
    public ResponseEntity<Quote> getQuote(@RequestParam String pair) {
        Quote q = quoteService.getQuote(pair);
        return (q == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(q);
    }


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
