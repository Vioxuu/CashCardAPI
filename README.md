# 💳 Family Cash Card API

### My journey through the Spring Academy "Building a REST API" course

This repository contains my implementation of the **Cash Card** service—a RESTful API designed to manage digital allowances for families. Rather than just following a tutorial, I used this project to master the "Spring Way" of building production-ready services.

---

## 🚀 What’s this about?

The core idea is simple: a system where parents can manage funds for their kids via digital cards. But under the hood, it’s a full-featured Spring Boot application that handles everything from data persistence to fine-grained security.

### Key Features:

* **Contract-First Development**: I started by defining the JSON structures before writing any business logic.
* **Strict TDD Workflow**: Every feature (CRUD, Pagination, Security) was driven by failing tests first. If there's no test, the feature doesn't exist.
* **Ownership-Based Security**: It's not just about logging in. The API ensures that a user can only interact with the cards they actually own.
* **Clean API Design**: Proper use of HTTP methods (`GET`, `POST`, `PUT`, `DELETE`) and status codes (201 Created, 204 No Content, 404 Not Found).

---

## 🛠 The Tech Stack

* **Java 17** (Using modern syntax and records).
* **Spring Boot 3** (The backbone of the app).
* **Spring Data JDBC** (For straightforward, high-performance database access).
* **H2 Database** (Fast, in-memory storage for development/testing).
* **Spring Security** (To handle authentication and resource authorization).

---

## 🕹 Getting Started

Want to see it in action? Here is how to get it running on your machine.

### Prerequisites

You'll need **JDK 17** installed. You don't need to worry about Gradle; the included wrapper handles everything.

### Running the App

1. **Clone the repo:**

   ```bash
   git clone https://github.com/Vioxuu/CashCardAPI.git
   ```

2. **Start the server:**

   ```bash
   ./gradlew bootRun
   ```

3. **Access the API:**
   The server starts at http://localhost:8080. Note that most endpoints require Basic Auth. You can find the test user credentials in SecurityConfig.java or the data.sql file.

---

## 🧪 Testing

Since this project follows TDD (Test-Driven Development), the tests are the best place to see the API's requirements in action:

```bash
./gradlew test
```

---

## 🧠 Key Takeaways

### 📐 API Design

Pagination & Sorting: How to handle large datasets efficiently without overloading the client or the server.

Resource Location: Using UriComponentsBuilder to return the correct URL of a newly created resource in the Location header—a small detail that makes an API truly RESTful.

### 🔐 Security & Ownership

Principal Injection: Learning how Spring Security automatically identifies the logged-in user.

Data Isolation: Ensuring users can only access their own Cash Cards, not their siblings'.

---

## 🤝 Acknowledgments

A big shout-out to the Spring Academy team for the excellent "Building a REST API with Spring Boot" course. It was a great way to sharpen my Spring skills and move beyond just "making it work" to "making it right."

---

## ☕ Happy coding!
