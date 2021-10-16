package com.it.cinemabackend.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BaseEntityTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    public static Object[][] getSetData() {
        return new Object[][] { { 0L }, { Long.MAX_VALUE } };
    }

    @ParameterizedTest
    @MethodSource("getSetData")
    void getSetId(long id) {
        BaseEntity baseEntity = new BaseEntity(id);
        assertEquals(id, baseEntity.getId());
    }

    @Test
    void isNew() {
        BaseEntity baseEntity = new BaseEntity();
        assertTrue(baseEntity.isNew());
        baseEntity.setId(0L);
        assertFalse(baseEntity.isNew());
    }
}
