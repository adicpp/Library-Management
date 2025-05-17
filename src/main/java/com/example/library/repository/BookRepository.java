package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, is_issued, genre, location) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.isIssued(), book.getGenre(), book.getLocation());
    }

    public void updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, is_issued = ?, genre = ?, location = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.isIssued(), book.getGenre(), book.getLocation(), book.getId());
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, this::mapRowToBook);
    }

    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToBook);
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setIssued(rs.getBoolean("is_issued"));
        book.setGenre(rs.getString("genre"));
        book.setLocation(rs.getString("location"));
        return book;
    }
}
