# Order & Notification Management Platform

## Overview

Order & Notification Management Platform is an enterprise-style microservices application built using Java and Spring Boot.

The project is being developed incrementally to demonstrate REST API development, database integration, validation, exception handling, logging, messaging, security, and microservice architecture.

## Current Implementation

### Customer Service

The Customer Service manages customer information and provides REST APIs for customer management.

### Features

* Create customer
* Get all customers
* Get customer by ID
* Update customer
* Delete customer
* Request validation
* Global exception handling
* Custom business exception
* Structured error responses
* Application logging
* MySQL database integration

## REST APIs

| Method | Endpoint          | Description        |
| ------ | ----------------- | ------------------ |
| POST   | `/customers`      | Create a customer  |
| GET    | `/customers`      | Get all customers  |
| GET    | `/customers/{id}` | Get customer by ID |
| PUT    | `/customers/{id}` | Update customer    |
| DELETE | `/customers/{id}` | Delete customer    |

## Technologies

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* REST APIs
* Jakarta Validation
* SLF4J Logging
* Git & GitHub

## Customer Data

The Customer entity currently contains:

* `id`
* `name`
* `email`
* `phone`

## Validation

Customer requests are validated using Jakarta Bean Validation.

Examples:

* Name cannot be blank
* Email must have a valid format
* Phone number must contain 10 digits

## Exception Handling

The application uses centralized exception handling with `@RestControllerAdvice`.

Custom exception:

* `CustomerNotFoundException`

Validation errors and unexpected exceptions are also handled centrally.

## Error Response

The application returns structured error responses containing information such as:

* Timestamp
* HTTP status
* Error code
* Message
* Field-level validation errors
* Request path

## Logging

Application logs are written locally and are excluded from Git using `.gitignore`.

Sensitive configuration such as database credentials is supplied through environment variables instead of being hardcoded in the repository.

## Project Structure

```text
customer-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/ns/customerservice/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── exception/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│
├── pom.xml
└── README.md
```

## Future Enhancements

The following components will be added incrementally:

* Order Service
* Notification Service
* API Gateway
* Kafka event-driven communication
* Spring Security and JWT authentication
* Swagger/OpenAPI documentation
* Unit and integration testing
* Docker
* CI/CD with GitHub Actions
* Architecture documentation

## Development Status

Customer Service CRUD and foundational backend features are currently implemented.

The remaining components will be added incrementally as the project evolves.
