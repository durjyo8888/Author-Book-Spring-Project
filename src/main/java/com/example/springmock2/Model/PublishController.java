package com.example.springmock2.Model;

import com.example.springmock2.Controller.Publish;
import com.example.springmock2.Service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishController {
    @Autowired
    PublishService publishService;
    @PostMapping("/publish-book")
    public ResponseEntity publishBook(@RequestBody Publish publish){
        Publish savedPublish = publishService.publishBook(publish);
        return new ResponseEntity(savedPublish, HttpStatus.CREATED);
    }
}
