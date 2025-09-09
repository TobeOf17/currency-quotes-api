# Currency Quotes API

A simple Java 21 + Spring Boot 3 project demonstrating CI/CD with GitHub Actions, 
Spotless code formatting, unit & integration tests, and JaCoCo coverage reporting.

## Features
- `POST /api/v1/quote` → Save a currency quote
- `GET /api/v1/quote?pair=USD/NGN` → Retrieve a currency quote

## Tech Stack
- Java 21
- Spring Boot 3
- Maven
- GitHub Actions (CI/CD)
- Spotless (code formatting)
- JaCoCo (coverage)

## Usage
Start the app locally:
```bash
mvn spring-boot:run

How the API Works

The API exposes endpoints to fetch currency exchange rates.

Rates are stored in an in-memory map (no database or external API).

Each request returns the conversion pair, its price, and the last updated timestamp.

Supported pairs include NGN/USD, NGN/EUR, NGN/GBP, NGN/JPY, NGN/CAD, NGN/AUD (and their reverse pairs).

GET all NGN conversion rates
curl -s http://localhost:8080/api/v1/naira/convert | jq

GET single currency pair by query
curl -s "http://localhost:8080/api/v1/quote?pair=NGN/USD" | jq

POST example (adding a new pair)
curl -X POST http://localhost:8080/api/v1/quote \
  -H "Content-Type: application/json" \
  -d '{"pair": "USD/NGN", "price": 1520.00}'
