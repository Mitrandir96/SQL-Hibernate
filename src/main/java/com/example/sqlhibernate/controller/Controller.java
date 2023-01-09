package com.example.sqlhibernate.controller;

import com.example.sqlhibernate.entities.Person;
import com.example.sqlhibernate.repository.Repository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
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

    @Secured({"ROLE_READ"})
    @GetMapping("/read")
    public String read() {
        return "Read";
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/write")
    public String write() {
        return "Write";
    }
    @PreAuthorize("hasAnyRole('DELETE')")
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }


    @GetMapping("/authUser")
    @PreAuthorize("#username == authentication.principal.username")
    public String greetingUser(String username) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "Hello from secure app, " + username;
    }


}
