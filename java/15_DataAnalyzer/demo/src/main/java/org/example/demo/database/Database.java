package org.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection connection;

    private Database(String url, String username, String password){
        Database.URL = url;
        Database.USERNAME = username;
        Database.PASSWORD = password;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance(String url, String username, String password) {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database(url, username, password);
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
