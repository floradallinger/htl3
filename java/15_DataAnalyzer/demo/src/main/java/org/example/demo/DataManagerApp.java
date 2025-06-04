package org.example.demo;

import javafx.application.Application;

import javafx.stage.Stage;
import org.example.demo.view.DataPresenter;

public class DataManagerApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DataPresenter.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}
