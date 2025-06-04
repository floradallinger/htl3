package org.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;

    private String url;
    private String username;
    private String password;

    private static Connection connection;

    public Database(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Datenbankverbindung geschlossen");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
