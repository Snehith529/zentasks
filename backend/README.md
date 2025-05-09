# 📦 ZenTasks Backend – Spring Boot

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
- IDE (e.g., Eclipse/IntelliJ)
- Postman or Curl (for API testing)

### ⚙️ Run the App
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### 🐳 Run via Docker
```bash
docker-compose up --build
```

> API at: [http://localhost:8081/api](http://localhost:8081/api)

---