package com.example.springmock2.Controller;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int bookId;
    String authorEmail;
    String yearOfPublish;
}
