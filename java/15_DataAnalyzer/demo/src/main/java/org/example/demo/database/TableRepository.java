package org.example.demo.database;

import javafx.scene.control.Tab;
import org.example.demo.model.Table;

import java.sql.Connection;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;

public class TableRepository {
    private Connection connection;

    private String url;
    private String username;
    private String password;

    public TableRepository(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;

        Database database = new Database(url, username, password);
        connection = database.getConnection();
    }

    public List<Table> getAllTableNames(){
        List<Table> tableList = new ArrayList<>();

        String sql = "SHOW TABLES";

        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()){
                Table table = new Table(rs.getString("table_name"));
                tableList.add(table);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tableList;
    }
}
