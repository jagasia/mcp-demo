# Calculator Service + Client

This workspace contains two Spring Boot Maven projects built with Java 21 and Spring Boot 4.0.0:

1. calculator-service (port 8080) - simple REST API that adds and subtracts two numbers.
2. calculator-client (port 8081) - calls the calculator-service endpoints using RestTemplate and exposes proxy endpoints.

Quick run (PowerShell):

1. Start the calculator service:

```powershell
cd D:\Jag\Empower\2026\testing\calculator-service
mvn spring-boot:run
```

2. In a new terminal start the client:

```powershell
cd D:\Jag\Empower\2026\testing\calculator-client
mvn spring-boot:run
```

3. Example calls:

- Direct to calculator service:

```powershell
curl "http://localhost:8080/api/calc/add?a=5&b=3"
curl "http://localhost:8080/api/calc/subtract?a=10&b=4"
```

- Via client proxy:

```powershell
curl "http://localhost:8081/proxy/add?a=5&b=3"
curl "http://localhost:8081/proxy/subtract?a=10&b=4"
```

If you change the calculator service URL, update `calculator-client/src/main/resources/application.properties` or set `-Dcalculator.service.url=...` when running the client.

## Tests

The client now includes a test package at `calculator-client/src/test/java`.

Run the client tests with:

```powershell
cd D:\Jag\Empower\2026\testing\calculator-client
mvn test
```
