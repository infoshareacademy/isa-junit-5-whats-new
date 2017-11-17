package com.infoshareacademy.karierait.junit5.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("ThrowableResultOfMethodCallIgnored")
public class ConfigFactoryTest {
    @Test
    public void shouldReturnConfigWithDefaultSettings() {
        Config config = ConfigFactory.getDefault();

        assertAll("Default database settings", () -> {
            assertEquals("http://localhost", config.getDatabaseHost());
            assertEquals(9999, config.getDatabasePort());
        });

        assertEquals("karierait", config.getDomain());
    }

    @Test
    public void shouldReturnConfigWithProvidedDatabaseSettings() {
        Config config = ConfigFactory.getForDatabase("http://somedomain.com", 3000);

        assertAll("Provided database settings", () -> {
            assertEquals("http://somedomain.com", config.getDatabaseHost());
            assertEquals(3000, config.getDatabasePort());
        });

        assertEquals("karierait", config.getDomain());
    }

    @Test
    public void shouldThrowExceptionWhenHostIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ConfigFactory.getForDatabase(null, 3000);
        });
    }

    @Test
    public void shouldThrowExceptionWhenHostIsEmpty() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ConfigFactory.getForDatabase("", 3000);
        });

        assertEquals("Host cannot be empty!", exception.getMessage());
    }
}
