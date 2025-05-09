---

# 🧠 ZenTasks – Full Stack Task Management App

ZenTasks is a minimalist, secure, and scalable task management application built using **Spring Boot**, **React.js**, and **JWT-based authentication**. Users can register, log in, and manage their tasks with tag support in a clean dashboard UI.

---

## ⚙️ Tech Stack

| Layer      | Tech                           |
|------------|--------------------------------|
| Backend    | Java 21, Spring Boot 3, Spring Security (JWT), Spring Data JPA, H2 |
| Frontend   | React.js, Axios, Tailwind CSS, React Router |
| Auth       | JWT-based authentication       |
| DB         | H2 (In-Memory, dev)            |
| Test       | JUnit 5, Mockito               |
| DevOps     | Docker, Docker Compose         |

---

## 🚀 Setup Instructions

### 🛠 Backend Setup (Spring Boot)
```bash
git clone https://github.com/Snehith529/zentasks
cd zentasks/backend
mvn clean install
mvn spring-boot:run
```

> Runs on: [http://localhost:8081](http://localhost:8081)

### 🐳 Backend via Docker
```bash
cd zentasks
docker-compose up --build
```

---

### 💻 Frontend Setup (React)
```bash
cd zentasks/frontend
npm install
npm start
```

> Runs on: [http://localhost:3000](http://localhost:3000)

### 🐳 Frontend via Docker
> Already handled by `docker-compose.yml`. Open browser at `http://localhost:3000`

---

## 🔐 Authentication Flow

### ✅ Register User
```bash
curl -X POST http://localhost:8081/api/auth/register -H "Content-Type: application/json" -d "{\"name\":\"John Doe\", \"email\":\"john@example.com\", \"password\":\"mypassword\"}"
```

### ✅ Login User
```bash
curl -X POST http://localhost:8081/api/auth/login -H "Content-Type: application/json" -d "{\"email\":\"john@example.com\", \"password\":\"mypassword\"}"
```

### ✅ Sample Response (Login)
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Use this JWT token for authenticated requests with:
```http
Authorization: Bearer <token>
```

---

## 📂 Project Structure

```
zentasks/
├── backend/
│   ├── controllers/
│   ├── dto/
│   ├── entities/
│   ├── security/
│   ├── services/
│   └── application.properties
│
├── frontend/
│   ├── pages/
│   │   ├── LoginPage.js
│   │   ├── RegisterPage.js
│   │   └── Dashboard.js
│   ├── api/axios.js
│   └── App.js
```

---

## 🧪 API Reference

| Endpoint               | Method | Description            |
|------------------------|--------|------------------------|
| `/api/auth/register`   | POST   | Register new user      |
| `/api/auth/login`      | POST   | Login & receive JWT    |
| `/api/tasks/user/{id}` | GET    | Fetch tasks for a user |
| `/api/tasks`           | POST   | Create new task (auth) |

---

## 🛠 Default Test User
```bash
Email: test@example.com
Password: password123
```

---

## ✅ Testing the Backend
```bash
cd backend
mvn test
```

---

## 👨‍💻 Author
Created by **Snehith Kongara**  
GitHub: [@Snehith529](https://github.com/Snehith529)

---