package com.example.sqlhibernate.entities;

import javax.persistence.Id;
import java.io.Serializable;

public class PersonId implements Serializable {

    private String name;
    private String surname;
    private int age;

    public PersonId (String name, String surname, int age) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
}
