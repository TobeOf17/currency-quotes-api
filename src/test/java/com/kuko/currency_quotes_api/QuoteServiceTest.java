package com.kuko.currency_quotes_api;

import static org.junit.jupiter.api.Assertions.*;

import com.kuko.currency_quotes_api.service.QuoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuoteServiceTest {

    private QuoteService quoteService;

    @BeforeEach
    void setup() {
        quoteService = new QuoteService();
    }

    @Test
    void testGetQuoteNotNull() {
        var quote = quoteService.getQuote("USD/NGN");
        assertNotNull(quote, "Quote should not be null for USD/NGN");
    }

    @Test
    void testGetQuoteUnsupportedPair() {
        assertThrows(
                IllegalArgumentException.class,
                () -> quoteService.getQuote("XYZ/ABC"),
                "Unsupported pair should throw IllegalArgumentException");
    }
}
