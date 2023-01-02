package com.example.sqlhibernate.repository;

import com.example.sqlhibernate.entities.Person;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Person> getPersonsByCity(String city) {

        Query query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city")
                .setParameter("city", city);
        return query.getResultList();
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
