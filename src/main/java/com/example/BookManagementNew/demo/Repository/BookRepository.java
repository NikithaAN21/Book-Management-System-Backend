package com.example.BookManagementNew.demo.Repository;


import com.example.BookManagementNew.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}