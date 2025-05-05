
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

---

## 🚀 Setup Instructions

### 🛠 Backend Setup (Spring Boot)
```bash
git clone https://github.com/Snehith529/zentasks
cd zentasks/backend
mvn clean install
mvn spring-boot:run
````

> App runs on: [http://localhost:8080](http://localhost:8080)

---

### 💻 Frontend Setup (React)

```bash
cd zentasks/frontend
npm install
npm start
```

> App runs on: [http://localhost:3000](http://localhost:3000)

---

## 🔐 Authentication Flow

### ✅ Register User

```bash
curl -X POST http://localhost:8080/api/auth/register ^
  -H "Content-Type: application/json" ^
  -H "Accept: application/json" ^
  -d "{\"name\":\"John Doe\", \"email\":\"john@example.com\", \"password\":\"mypassword\"}"
```

### ✅ Login User

```bash
curl -X POST http://localhost:8080/api/auth/login ^
  -H "Content-Type: application/json" ^
  -H "Accept: application/json" ^
  -d "{\"email\":\"john@example.com\", \"password\":\"mypassword\"}"
```

### ✅ Sample Response (Login)

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Save this token and include it in all subsequent requests using:

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
| ---------------------- | ------ | ---------------------- |
| `/api/auth/register`   | POST   | Register new user      |
| `/api/auth/login`      | POST   | Login & receive JWT    |
| `/api/tasks/user/{id}` | GET    | Fetch tasks for a user |
| `/api/tasks`           | POST   | Create new task (auth) |

---

## 🛠 Default Test User

Use this if you skip manual registration:

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




```
