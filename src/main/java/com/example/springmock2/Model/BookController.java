package com.example.springmock2.Model;

import com.example.springmock2.Controller.Publish;
import com.example.springmock2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity addBook(@RequestParam("bookName") String bookName, @RequestParam("pages") int pages, @RequestParam("email") String authorEmail){
        try{
            bookService.addBook(bookName,pages,authorEmail);
            return new ResponseEntity("book added successfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/no-of-books")
    public ResponseEntity findBooks(@RequestParam String year, @RequestParam String authorEmail){
        int books = bookService.findBooks(year,authorEmail);
        return new ResponseEntity(books,HttpStatus.FOUND);
    }
}
