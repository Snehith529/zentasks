
ZenTasks is a minimalist task management backend API built with Spring Boot, Spring Security, JPA, and JWT-based authentication.

---

## 📦 Features

- REST APIs for Users, Tasks, Tags
- JWT-based Authentication (`/login`, `/register`)
- Spring Security with role-based setup
- DTOs with validation and mapping
- H2 in-memory database for dev/testing
- CORS config for React frontend
- Unit tests with JUnit + Mockito

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 21
- Maven
- IDE (Eclipse)
- Postman or Curl (for testing)

### ⚙️ Run the App

```bash
# Clone the project
git clone https://github.com/your-username/zentasks-backend.git
cd zentasks-backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
