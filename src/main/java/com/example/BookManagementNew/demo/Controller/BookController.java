package com.example.BookManagementNew.demo.Controller;

import com.example.BookManagementNew.demo.Entity.Book;
import com.example.BookManagementNew.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5176") // 🔥 better for dev
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // ✅ CREATE
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // ✅ GET ALL
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    // ✅ GET BY ID (VIEW)
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }
}