package com.infoshareacademy.karierait.junit5.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {
    @Test
    public void shouldReturnEmptyStringWhenBothArgumentsAreNull() {
        String arg1 = null;
        String arg2 = null;
        String expected = "";

        String concatenated = StringUtils.concat(arg1, arg2);

        assertEquals(concatenated, expected, () ->
            "Expected concatenation of " + arg1 + " with " + arg2 + " to result in " + expected
        );
    }

    @Test
    public void shouldReturnFirstArgumentWhenSecondIsNull() {
        String arg1 = "argument 1";
        String arg2 = null;
        String expected = "argument 1";

        String concatenated = StringUtils.concat(arg1, arg2);

        assertEquals(concatenated, expected, () ->
            "Expected concatenation of " + arg1 + " with " + arg2 + " to result in " + expected
        );
    }

    @Test
    public void shouldReturnSecondArgumentWhenFirstIsNull() {
        String arg1 = null;
        String arg2 = "argument 2";
        String expected = "argument 2";

        String concatenated = StringUtils.concat(arg1, arg2);

        assertEquals(concatenated, expected, () ->
            "Expected concatenation of " + arg1 + " with " + arg2 + " to result in " + expected
        );
    }

    @Test
    public void shouldReturnConcatenatedArguments() {
        String arg1 = "argument 1";
        String arg2 = "argument 2";
        String expected = "argument 1argument 2";

        String concatenated = StringUtils.concat(arg1, arg2);

        assertEquals(concatenated, expected, () ->
            "Expected concatenation of " + arg1 + " with " + arg2 + " to result in " + expected
        );
    }



}
