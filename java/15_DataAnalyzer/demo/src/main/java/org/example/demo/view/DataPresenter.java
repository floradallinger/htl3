package org.example.demo.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataPresenter {
    private final DataView view;

    private DataPresenter(DataView view){
        this.view = view;
    }

    public static void show(Stage stage){
        DataView view = new DataView();
        DataPresenter controller = new DataPresenter(view);

        Scene scene = new Scene(view.getRoot());
        stage.setTitle("Data Manager");
        stage.setScene(scene);
        stage.show();
    }

}
