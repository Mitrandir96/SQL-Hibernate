package com.example.sqlhibernate.repositories;

import com.example.sqlhibernate.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findPersonByCityOfLiving(String city);
    List<Person> findPersonByAgeLessThanOrderByAgeAsc(int age);
    Optional<Person> findPersonByNameAndSurname(String name, String surname);
}
