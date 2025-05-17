package com.example.library.repository;

import com.example.library.model.BorrowingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class BorrowingHistoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void issueBook(BorrowingHistory history) {
        String sql = "INSERT INTO borrowing_history (student_id, book_id, issue_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, history.getStudentId(), history.getBookId(), new Date());
    }

    public void returnBook(int bookId, String studentId) {
        String sql = "UPDATE borrowing_history SET return_date = ? WHERE book_id = ? AND student_id = ? AND return_date IS NULL";
        jdbcTemplate.update(sql, new Date(), bookId, studentId);
    }
}
