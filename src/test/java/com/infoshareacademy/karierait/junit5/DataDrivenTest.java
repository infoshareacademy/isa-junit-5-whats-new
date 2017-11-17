package com.infoshareacademy.karierait.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataDrivenTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void valueSourceTest(int argument) {
        assertTrue(argument > 0);
    }

    @ParameterizedTest
    @MethodSource(value = {"generatePositiveNumbers"})
    public void methodSourceTest(int argument) {
        assertTrue(argument > 0);
    }

    private static int[] generatePositiveNumbers() {
        return new int[]{1, 2, 3, 4, 5};
    }

    @ParameterizedTest
    @MethodSource(value = {"generateStreamOfArguments"})
    public void streamOfArgumentsTest(int number, int expectedResult) {
        assertEquals(expectedResult, Math.pow(number, 2));
    }

    private static Stream<Arguments> generateStreamOfArguments() {
        return Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 4),
            Arguments.of(3, 9),
            Arguments.of(4, 16),
            Arguments.of(5, 25)
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/math_pow_test_data.csv"}, delimiter = ';')
    public void csvFileSourceTest(int number, int expectedResult) {
        assertEquals(expectedResult, Math.pow(number, 2));
    }
}
