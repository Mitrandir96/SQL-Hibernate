package com.example.sqlhibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONS")
@IdClass(PersonId.class)
public class Person {
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;
    private String phoneNumber;
    private String cityOfLiving;
}
