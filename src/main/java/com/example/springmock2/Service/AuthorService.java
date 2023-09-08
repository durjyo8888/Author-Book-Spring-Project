package com.example.springmock2.Service;

import com.example.springmock2.Controller.Author;
import com.example.springmock2.Controller.Book;
import com.example.springmock2.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public Author addAuthor(Author author) {
        author.setBookList(new ArrayList<>());
        return authorRepository.save(author);
    }

    //GET API -Find the list of name of authors and their age who have written maximum no. of pages during lifetime
    public String getAuthorName() {
        List<Author> authorList = authorRepository.findAll();

        int max = 0;
        String author = "";

        for(Author currAuthor : authorList){
            List<Book> bookList = currAuthor.getBookList();
            int sum = 0;
            for(Book currBook : bookList){
                sum+= currBook.getPages();
                if(max < sum){
                    max = sum;
                    author = currAuthor.getEmail();
                }
            }
        }
        return author;
    }
}
