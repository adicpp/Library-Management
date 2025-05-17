package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.User;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = libraryService.login(username, password);
        return (user != null) ? "Login successful" : "Invalid credentials";
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book) {
        libraryService.addBook(book);
        return "Book added successfully";
    }

    @PutMapping("/books")
    public String updateBook(@RequestBody Book book) {
        libraryService.updateBook(book);
        return "Book updated successfully";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id) {
        libraryService.deleteBook(id);
        return "Book deleted successfully";
    }

    @GetMapping("/books")
    public List<Book> listBooks() {
        return libraryService.listBooks();
    }

    @PostMapping("/issue")
    public String issueBook(@RequestParam String studentId, @RequestParam int bookId) {
        libraryService.issueBook(studentId, bookId);
        return "Book issued successfully";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String studentId, @RequestParam int bookId) {
        libraryService.returnBook(studentId, bookId);
        return "Book returned successfully";
    }
}
