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
