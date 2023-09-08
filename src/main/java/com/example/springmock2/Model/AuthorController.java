package com.example.springmock2.Model;

import com.example.springmock2.Controller.Author;
import com.example.springmock2.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public ResponseEntity addAuthor(@RequestBody Author author){
        Author savedAuthor = authorService.addAuthor(author);
        return new ResponseEntity(savedAuthor, HttpStatus.CREATED);
    }
    //GET API -Find the list of name of authors and their age who have written maximum no. of pages during lifetime
    @GetMapping("/author-name")
    public ResponseEntity getAuthorName(){
        String author = authorService.getAuthorName();
        return new ResponseEntity(author,HttpStatus.FOUND);
    }
}
