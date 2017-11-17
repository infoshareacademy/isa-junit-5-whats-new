package com.infoshareacademy.karierait.junit5.config;

public class ConfigFactory {
    private static final String DEFAULT_DATABASE_HOST = "http://localhost";
    private static final int DEFAULT_DATABASE_PORT = 9999;
    private static final String DEFAULT_DOMAIN = "karierait";

    public static Config getDefault() {
        Config config = new Config();

        config.setDatabaseHost(DEFAULT_DATABASE_HOST);
        config.setDatabasePort(DEFAULT_DATABASE_PORT);
        config.setDomain(DEFAULT_DOMAIN);

        return config;
    }

    public static Config getForDatabase(String host, int port) {
        if (host == null || host.equals("")) {
            throw new IllegalArgumentException("Host cannot be empty!");
        }

        Config config = new Config();

        config.setDatabaseHost(host);
        config.setDatabasePort(port);
        config.setDomain(DEFAULT_DOMAIN);

        return config;
    }
}
