package org.example.demo.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import org.example.demo.model.Column;
import org.example.demo.model.Table;

public class DataView {

    private final BorderPane root = new BorderPane();

    // UI elements
    private final TextField tfUrl = new TextField();
    private final TextField tfUser = new TextField();
    private final TextField tfPw = new TextField();
    private final Button btnConnect = new Button("Connect");

    private final TreeView<Table> trvTables = new TreeView<>();
    private final TableView<Column> tvColumns = new TableView<>();

    public DataView() {
        init();
    }

    private void init() {
        root.setPrefSize(1300, 700);

        // === TOOLBAR DESIGN ===
        HBox toolbar = new HBox(15);
        toolbar.setPadding(new Insets(15));
        toolbar.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 0, 1, true,
                        javafx.scene.paint.CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#4a4a4a")),
                        new Stop(1, Color.web("#2e2e2e"))),
                new CornerRadii(2),
                Insets.EMPTY
        )));
        toolbar.setEffect(new DropShadow(10, Color.rgb(0, 0, 0, 0.4)));
        toolbar.setBorder(new Border(new BorderStroke(
                Color.DARKSLATEGRAY, BorderStrokeStyle.SOLID,
                new CornerRadii(2), new BorderWidths(1)
        )));

        toolbar.setPrefHeight(30);

        // === INPUT STYLING ===
        String textFieldStyle = "-fx-background-color: white; " +
                "-fx-background-radius: 6; " +
                "-fx-border-radius: 6; " +
                "-fx-border-color: #cccccc; " +
                "-fx-padding: 4 8;";

        tfUrl.setPromptText("Database URL");
        tfUser.setPromptText("Username");
        tfPw.setPromptText("Password");

        tfUrl.setPrefWidth(400);
        tfUser.setPrefWidth(150);
        tfPw.setPrefWidth(150);

        tfUrl.setStyle(textFieldStyle);
        tfUser.setStyle(textFieldStyle);
        tfPw.setStyle(textFieldStyle);

        // === BUTTON STYLING ===
        btnConnect.setPrefWidth(120);
        btnConnect.setStyle("-fx-background-color: linear-gradient(#053107, #0b4d0e); " +
                "-fx-text-fill: white; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 6; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 4, 0, 1, 2);");

        toolbar.getChildren().addAll(tfUrl, tfUser, tfPw, btnConnect);

        // === TREEVIEW & TABLE ===
        trvTables.setPrefWidth(250);
        trvTables.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc;");

        tvColumns.setStyle("-fx-background-color: #ffffff;");
        tvColumns.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // === ROOT PLACEMENT ===
        root.setTop(toolbar);
        root.setLeft(trvTables);
        root.setCenter(tvColumns);
    }

    public BorderPane getRoot() {
        return root;
    }
}
