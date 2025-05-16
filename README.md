# 📚 Library Management System

A simple Spring Boot project to help librarians manage books and track student borrowing using Java, JDBC, and PostgreSQL.

## ✅ Features
- Librarian login
- Add, update, delete, view books
- Issue and return books using student IDs
- Borrowing history tracking

## 🛠 Tech Stack
- Java + Spring Boot
- JDBC + PostgreSQL
- Maven

## 🚀 Getting Started
1. Clone the repo
2. Configure `application.properties` with your PostgreSQL credentials
3. Create tables using `schema.sql`
4. Run the project with:
   ```bash
   mvn spring-boot:run
   ```

## 🔗 Sample APIs
| Method | Endpoint         | Action           |
|--------|------------------|------------------|
| POST   | /login           | Login librarian  |
| GET    | /books           | List books       |
| POST   | /books           | Add book         |
| PUT    | /books/{id}      | Update book      |
| DELETE | /books/{id}      | Delete book      |
| POST   | /books/issue     | Issue book       |
| POST   | /books/return    | Return book      |
| GET    | /history         | View history     |

---

**Author:** Aditya ([GitHub](https://github.com/adicpp))
