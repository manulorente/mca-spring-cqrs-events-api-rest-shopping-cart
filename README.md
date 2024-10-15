# Shopping Cart Service

This is a simple shopping cart service of an event-driven shopping cart application utilizing the Axon Framework and Axon Server for managing events and commands. This application follows the Command Query Responsibility Segregation (CQRS) and Event Sourcing patterns, allowing for a clean separation between read and write operations while persisting the state of the shopping cart through event storage.

## Tech stack

| **Technology** | **Description** |
|----------------|-----------------|
| Java | 11 |
| Spring Boot | 2.6.7 |
| Axon Framework | 4.5.12 |
| Maven | 3.8.1 |
| Docker | 20.10.8 |

## Getting Started

### Prerequisites

- Java 11
- Maven

### Running the Application

1. Clone the repository

2. Navigate to the project directory

3. Run Axon Server

  ```bash
  docker run -d --name axonserver -p 8024:8024 -p 8124:8124 axoniq/axonserver:4.5.12
  ```

4. Build the project

  ```bash
  mvn clean install -DskipTests
  ```

5. Run the application

  ```bash
  mvn spring-boot:run
  ```

## API testing

### Create a customer

  ```bash
  curl -X POST -H "Content-Type: application/json" -d "{  \"fullName\": \"John Doe\",  \"address\": \"Unknown\"}" http://localhost:8080/customers
  ```

### Get a single customer

  ```bash
  curl -X GET -H "Content-Type: application/json" http://localhost:8080/customers/0b61f8e8-064e-4962-b344-c7e97f493c51
  ```

### Get all customers

  ```bash
  curl -X GET -H "Content-Type: application/json" http://localhost:8080/customers
  ```

### Create a product

  ```bash
  curl -X POST -H "Content-Type: application/json" -d "{  \"name\": \"iPhone 12\", \"description\": \"Iphone\", \"price\": 1000}" http://localhost:8080/products
  ```

### Get a single product

  ```bash
  curl -X GET -H "Content-Type: application/json" http://localhost:8080/products/9d3bc78c-78ba-46a3-a26d-7717f2b7e697
  ```

### Get all products

  ```bash
  curl -X GET -H "Content-Type: application/json" http://localhost:8080/products
  ```

### Create shopping cart given a customer id

  ```bash
  curl -X POST -H "Content-Type: application/json" http://localhost:8080/customers/0b61f8e8-064e-4962-b344-c7e97f493c51/cart
  ```

### Add a product to a shopping cart

  ```bash
  curl -X POST -H "Content-Type: application/json" http://localhost:8080/carts/0b61f8e8-064e-4962-b344-c7e97f493c51/product/b28b1871-8832-455e-96d9-718f01cbe972?quantity=10
  ```

### Get a shopping cart

  ```bash
  curl -X GET -H "Content-Type: application/json" http://localhost:8080/carts/9248d336-1ddf-458e-99da-df7ec0bb4a16
  ```

### Get all shopping carts

  ```bash
  curl -X GET -H "Content-Type: application/json" http://localhost:8080/carts
  ```

### Remove a product from a shopping cart

  ```bash
  curl -X DELETE -H "Content-Type: application/json" http://localhost:8080/carts/9248d336-1ddf-458e-99da-df7ec0bb4a16/product/b28b1871-8832-455e-96d9-718f01cbe972?quantity=5
  ```

### Get all items removed from a shopping cart

  ```bash
  curl -X GET -H "Content-Type: application/json" http://localhost:8080/carts/9248d336-1ddf-458e-99da-df7ec0bb4a16/removed-items
  ```

## Change Log

| **Version** | **Description** |
|-------------|-----------------|
| 0.0.1       | Initial release |

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
