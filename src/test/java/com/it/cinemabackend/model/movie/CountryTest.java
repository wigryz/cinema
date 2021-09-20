package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountryTest {

    Country country;

    @BeforeEach
    void setUp() {
        country = new Country();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSetName() {
        String name = "Poland";
        country.setName(name);
        assertEquals(name, country.getName());
    }

}
