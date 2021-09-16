package com.it.cinemabackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CinemaBackendApplicationIT {

    @Test
    void contextLoads() {
    }

    @Test
    void failingITTest() {
        assertEquals(0, 1);
    }

}
