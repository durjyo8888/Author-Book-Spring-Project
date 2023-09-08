package com.example.springmock2.Service;

import com.example.springmock2.Controller.Publish;
import com.example.springmock2.Repository.PublishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {
    @Autowired
    PublishRepository publishRepository;
    public Publish publishBook(Publish publish) {
        return publishRepository.save(publish);
    }
}
