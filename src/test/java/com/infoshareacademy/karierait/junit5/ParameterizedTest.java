package com.infoshareacademy.karierait.junit5;

import com.infoshareacademy.karierait.junit5.annotations.Console;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Console
    public class ParameterizedTest {
        @BeforeAll
        public void beforeAll(TestInfo info) {
            System.out.println(info.getTestClass() + " :: beforeAll");
        }

        @BeforeAll
        public void beforeAll(TestReporter reporter) {
            reporter.publishEntry("parameterizedEntry", "someValue");
        }

        @AfterAll
        public void afterAll(TestInfo info) {
            System.out.println(info.getTestClass() + " :: afterAll");
        }

        @Test
        public void dummyTest(TestInfo info) {
            System.out.println(info.getTestClass() + " :: " + info.getDisplayName());
        }
    }

