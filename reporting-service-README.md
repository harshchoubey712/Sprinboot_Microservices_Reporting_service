
# Reporting Service - OpenAPI Based Microservice

This is a Spring Boot microservice named **reporting-service**, which consumes another service (transaction-db-service) using **OpenAPI generated client stubs**.

---

## 📑 OpenAPI Specs Generation

OpenAPI specs allow the contract-first development approach.

### ✅ How to generate client stubs

If you already have the OpenAPI spec (`transaction-db-service.yaml`), you can generate client stubs using:

```bash
openapi-generator generate   -i transaction-db-service.yaml   -g java   -o ./generated-client   --library resttemplate   --additional-properties=useSpringBoot3=true
```

**Options explained**:
- `-i` → input OpenAPI file
- `-g java` → generate Java client
- `--library resttemplate` → use RestTemplate as client
- `--additional-properties` → pass Spring Boot 3 flags

Generated interface (like `DefaultApi`) will be implemented by the controller and used by service classes.

---

## ⚙️ Project Structure

```
reporting-service/
├── controller/
│   └── ReportingController.java
├── service/
│   └── ReportingService.java
├── dto/
│   └── TransactionDTO.java
│   └── TransactionPage.java
├── client/
│   └── api/DefaultApi.java        <-- from OpenAPI generator
├── ReportingServiceApplication.java
└── application.yml
```

---

## 🧩 Flow Explanation

### 1. Controller

```java
@RestController
@RequestMapping("/report")
public class ReportingController {

    private final ReportingService reportingService;

    public ReportingController(ReportingService service) {
        this.reportingService = service;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<TransactionPage> getByStatus(@PathVariable BigDecimal status) {
        return ResponseEntity.ok(reportingService.getTransactionsByStatus(status));
    }
}
```

### 2. Service

```java
@Service
public class ReportingService {

    private final DefaultApi defaultApi; // OpenAPI client

    public ReportingService(DefaultApi defaultApi) {
        this.defaultApi = defaultApi;
    }

    public TransactionPage getTransactionsByStatus(BigDecimal status) {
        return defaultApi.getTransactionsByStatus(status, 0, 100, UUID.randomUUID().toString());
    }
}
```

Here, `defaultApi.getTransactionsByStatus(...)` is defined in the OpenAPI client stub.

---

## 📦 DTOs

### TransactionDTO

```java
public class TransactionDTO {
    private String id;
    private Double amount;
    private BigDecimal status;
}
```

### TransactionPage

```java
public class TransactionPage {
    private Integer total;
    private Integer offset;
    private Integer limit;
    private Integer count;
    private List<TransactionDTO> items;
}
```

These classes are used in both request and response payloads and help with JSON deserialization.

---

## 🔧 Swagger UI Setup

Add to `application.yml`:
```yaml
springdoc:
  api-docs:
    path: /v3/api-docs
  swagger-ui:
    path: /swagger-ui.html
```

Run the app and open: `http://localhost:8080/swagger-ui.html`

---

## ▶️ Running the Project

```bash
./mvnw clean install
./mvnw spring-boot:run
```

### Sample API Call

```bash
curl http://localhost:8080/report/status/1
```

---

## 🧠 Summary of Layers

| Layer        | Class                       | Purpose |
|--------------|-----------------------------|---------|
| Controller   | ReportingController         | Handles HTTP requests |
| Service      | ReportingService            | Business logic, calls OpenAPI client |
| OpenAPI Stub | DefaultApi                  | Generated interface to call external service |
| DTOs         | TransactionDTO, TransactionPage | Data models for API |
| Config       | application.yml             | Swagger + Spring Boot config |

---


