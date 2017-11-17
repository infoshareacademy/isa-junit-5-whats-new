package com.infoshareacademy.karierait.junit5;

import com.infoshareacademy.karierait.junit5.annotations.Console;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTestCase {

    @RepeatedTest(5)
    @Console
    public void repeatedTest(RepetitionInfo repetitionInfo) {
        int current = repetitionInfo.getCurrentRepetition();
        int total = repetitionInfo.getTotalRepetitions();

        System.out.println("Checking for the #" + current + " time out of " + total + " trials...");

        assertTrue(true);
    }
}
