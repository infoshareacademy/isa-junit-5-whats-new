package com.infoshareacademy.karierait.junit5;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifecycleTest {
    private Date firstDate = new Date();
    private Date secondDate;

    @BeforeAll
    public void beforeAll() {
        this.secondDate = this.firstDate;
    }

    @BeforeAll
    public void beforeEach() {
        assertEquals(firstDate, secondDate);
    }

    @AfterEach
    public void afterEach() {
        assertEquals(firstDate, secondDate);
    }

    @AfterAll
    public void afterAll() {
        assertEquals(firstDate, secondDate);
    }

    @Test
    public void firstTest() {
        assertEquals(firstDate, secondDate);
    }

    @Test
    public void secondTest() {
        assertEquals(firstDate, secondDate);
    }
}
