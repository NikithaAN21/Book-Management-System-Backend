
package com.example.BookManagementNew.demo.Service;

import com.example.BookManagementNew.demo.Entity.Book;
import com.example.BookManagementNew.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // ✅ CREATE
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // ✅ GET ALL
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ✅ GET BY ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // ✅ UPDATE
    public Book updateBook(Long id, Book book) {
        Book existing = getBookById(id);

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setDescription(book.getDescription());
        existing.setPrice(book.getPrice());

        return bookRepository.save(existing);
    }

    // ✅ DELETE
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}