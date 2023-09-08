package com.example.springmock2.Controller;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/*
* Spring 2 .Create an API for Book-Author management system ,where you are givenBook ,author ,publish:
* Book = name ,author_name,pages
* Author = name,age ,gender ,rating
* Publish= Book ,Author ,Year of publishing
* POST API Book name ,author name,no of pages
* POST API - Add book author name , age ,gender,rating
* GET API -Find the list of name of authors and their age who have written maximum no. of pages during lifetime
* GET API -Find the list of name of authors and their age who have written maximum no. of pages during lifetime
* Find the total number of books published by author A in year Y.*/
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String email;

    int age;
    String gender;
    int rating;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book>bookList;
}
