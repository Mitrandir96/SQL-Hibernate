package com.example.sqlhibernate.controller;

import com.example.sqlhibernate.entities.Person;
import com.example.sqlhibernate.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    Repository repository;
    public Controller(Repository repository) {
        this.repository = repository;
        repository.createTable();
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsbyCity(String city) {
        return repository.findPersonByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(int age) {
        return repository.findPersonByAgeAndOrderBy(age);
    }

    @GetMapping("/persons/by-fullname")
    public Optional<Person> findPersonByNameAndSurname(String name, String surname) {
        return repository.findPersonByNameAndSurname(name, surname);
    }
}
