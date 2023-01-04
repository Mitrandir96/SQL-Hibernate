package com.example.sqlhibernate.repository;

import com.example.sqlhibernate.entities.Person;
import com.example.sqlhibernate.repositories.PersonRepository;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    EntityManager entityManager;

    private PersonRepository personRepository;

    public Repository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> findPersonByCityOfLiving(String city) {

        return personRepository.findPersonByCityOfLiving(city);
    }

    public List<Person> findPersonByAgeAndOrderBy(int age) {

        return personRepository.findPersonByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> findPersonByNameAndSurname(String name, String surname) {

        return personRepository.findPersonByNameAndSurname(name, surname);
    }

    @Transactional
    public void createTable() {
        var names = List.of("Вася", "Петя", "Сергей", "Иван");
        var surnames = List.of("Петров", "Сидоров", "Иванов", "Ходаков");
        var cities = List.of("Москва", "Питер", "Лондон", "Челябинск");
        var random = new Random();
        IntStream.range(0, 4)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(100))
                            .phoneNumber("23123" + i)
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .build();
                    entityManager.persist(person);
                });
    }


}
