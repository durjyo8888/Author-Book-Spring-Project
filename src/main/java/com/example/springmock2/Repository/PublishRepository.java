package com.example.springmock2.Repository;

import com.example.springmock2.Controller.Publish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishRepository extends JpaRepository<Publish, Integer> {
    public List<Publish> findByYearOfPublish(String year);
}
