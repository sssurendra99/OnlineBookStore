# Online Book Store - Backend

## Features

- This is the microservices back end for the book store.

## Services Overview

### User Service 🧑‍💻
- Handles registration, login, profile management.
- JWT authentication.
- **Database:** PostgreSQL (users, roles).

### Book Service 📚
- CRUD for books (title, author, price, stock).
- Search/filter API.
- **Database:** MongoDB (flexible schema for books).

### Order Service 🛒
- Users can place orders for books.
- Keeps order history.
- Communicates with Book Service (to check stock) and User Service (for user info).
- **Database:** PostgreSQL.

### Notification Service 🔔
- Sends order confirmation emails/messages.
- Listens to events (e.g., order created) via RabbitMQ/Kafka.
- No database required (optionally Redis to keep logs).

### API Gateway (Spring Cloud Gateway) 🌐
- Routes external requests to the correct services.
- Performs auth check with JWT.
- Logging + rate limiting.

### Service Discovery (Eureka) 🔍
- Each microservice registers itself.
- Gateway and services communicate dynamically.

### Config Server (Spring Cloud Config) ⚙️
- Centralized configuration for all services.
- Git-backed (optional).
