package com.example.sqlhibernate.controller;

import com.example.sqlhibernate.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Repository repository;
    public Controller(Repository repository) {
        this.repository = repository;
        repository.createTable();
    }

    @GetMapping("/persons/by-city")
    public String getPersons(String city) {
        return repository.getPersonsByCity(city).toString();
    }
}
