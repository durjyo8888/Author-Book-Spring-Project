package com.example.springmock2.Repository;

import com.example.springmock2.Controller.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
