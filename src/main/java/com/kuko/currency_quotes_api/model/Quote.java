package com.kuko.currency_quotes_api.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Quote {
    private String pair;
    private BigDecimal price;
    private Instant updatedAt;

    public Quote(String pair, BigDecimal price, Instant updatedAt) {
        this.pair = pair;
        this.price = price;
        this.updatedAt = updatedAt;
    }

    public Quote(String pair, BigDecimal price) {
        this.pair = pair;
        this.price = price;
        this.updatedAt = Instant.now();
    }

    public Quote() {
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPair() {
        return pair;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        this.updatedAt = Instant.now();
    }
}
