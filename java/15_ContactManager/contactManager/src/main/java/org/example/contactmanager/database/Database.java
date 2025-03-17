package org.example.contactmanager.database;

import com.sun.jdi.connect.spi.Connection;

public class Database {
    private static Database instance;
    private final static String URL = "jdbc:h2:top://localhost:9092/./contactDb";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "sa";

    private static Connection connection;
}
