package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSetFirstName() {
        String firstName = "firstName";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    void getSetSecondName() {
        String secondName = "secondName";
        person.setSecondName(secondName);
        assertEquals(secondName, person.getSecondName());
    }

    @Test
    void getSetLastName() {
        String lastName = "lastName";
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName());
    }

    @Test
    void getSetSex() {
        person.setSex(Person.Sex.MALE);
        assertEquals(Person.Sex.MALE, person.getSex());
    }

    @Test
    void getSetBiography() {
        String biography = "biography";
        person.setBiography(biography);
        assertEquals(biography, person.getBiography());
    }
}
