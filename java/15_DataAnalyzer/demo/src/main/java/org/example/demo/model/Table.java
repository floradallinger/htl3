package org.example.demo.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Table {


    public StringProperty tableName = new SimpleStringProperty();
    public ObservableList<Column> columns = FXCollections.observableArrayList();

    public Table(){}

    public Table(String tableName){
        setTableName(tableName);
    }

    public String toString(){
        return "%s".formatted(
                getTableName()
        );
    }


    public StringProperty tableNameProperty() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName.set(tableName);
    }

    public String getTableName() {
        return tableName.get();
    }

}
