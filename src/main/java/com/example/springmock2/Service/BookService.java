package com.example.springmock2.Service;

import com.example.springmock2.Controller.Author;
import com.example.springmock2.Controller.Book;
import com.example.springmock2.Controller.Publish;
import com.example.springmock2.Repository.AuthorRepository;
import com.example.springmock2.Repository.BookRepository;
import com.example.springmock2.Repository.PublishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublishRepository publishRepository;
    public void addBook(String bookName, int pages, String authorEmail) {
        Author author = authorRepository.findByEmail(authorEmail);
        if(author == null){
            throw new RuntimeException("author not exist");
        }
        Book book = new Book();
        book.setBookName(bookName);
        book.setPages(pages);
        book.setAuthor(author);
        Book savedBook = bookRepository.save(book);

        author.getBookList().add(savedBook);
        authorRepository.save(author);
    }



    public int findBooks(String year, String authorEmail) {
        List<Publish>publishes = publishRepository.findByYearOfPublish(year);

        int count = 0;
        for(Publish publish : publishes){
            if(publish.getAuthorEmail().equals(authorEmail)){
                count++;
            }
        }
        return count;
    }
}
