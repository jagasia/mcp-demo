# product-api

Spring Boot 3 / Java 21 CRUD API for `Product (id, name, price, quantity)` backed by an H2 file database.
Used to demo CI/CD: GitHub -> CodePipeline -> CodeBuild -> Elastic Beanstalk (ap-south-1).

## Run locally

```
mvn spring-boot:run
```

Then open http://localhost:5000/api/products
H2 console: http://localhost:5000/h2-console (JDBC URL `jdbc:h2:file:./data/productdb`, user `sa`, empty password).

## Endpoints

| Method | Path               | Purpose         |
|--------|--------------------|-----------------|
| GET    | /                  | App info/health |
| GET    | /api/products      | List all        |
| GET    | /api/products/{id} | Get one         |
| POST   | /api/products      | Create          |
| PUT    | /api/products/{id} | Update          |
| DELETE | /api/products/{id} | Delete          |

Sample body: `{"name":"Monitor","price":8999.0,"quantity":5}`

## Pipeline files

- `buildspec.yml` - CodeBuild: run tests + package, publish JUnit report, output `product-api.jar` + `Procfile`
- `Procfile` - tells the Elastic Beanstalk Java SE platform how to start the jar
