package com.it.cinemabackend.model.movie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TechnologyTest {

    Technology technology;

    @BeforeEach
    void setUp() {
        technology = new Technology();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSetName() {
        String name = "3D";
        technology.setName(name);
        assertEquals(name, technology.getName());
    }

}
