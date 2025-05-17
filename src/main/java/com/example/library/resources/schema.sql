CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    is_issued BOOLEAN,
    genre VARCHAR(50),
    location VARCHAR(100)
);

CREATE TABLE borrowing_history (
    id SERIAL PRIMARY KEY,
    student_id VARCHAR(50),
    book_id INT REFERENCES books(id),
    issue_date DATE,
    return_date DATE
);
