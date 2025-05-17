package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BorrowingHistory;
import com.example.library.model.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowingHistoryRepository;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowingHistoryRepository historyRepository;

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public void issueBook(String studentId, int bookId) {
        BorrowingHistory history = new BorrowingHistory();
        history.setStudentId(studentId);
        history.setBookId(bookId);
        historyRepository.issueBook(history);
        Book book = bookRepository.findById(bookId);
        book.setIssued(true);
        bookRepository.updateBook(book);
    }

    public void returnBook(String studentId, int bookId) {
        historyRepository.returnBook(bookId, studentId);
        Book book = bookRepository.findById(bookId);
        book.setIssued(false);
        bookRepository.updateBook(book);
    }
}
