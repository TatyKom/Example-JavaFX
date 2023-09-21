package com.example.entercalories;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    public static GridPane initRootLayout() {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(15));

        Text title = new Text("Калькулятор калорий");
        Font fontBig = Font.font("Times New Roman", FontWeight.NORMAL, 26);
        title.setFont(fontBig);
        root.add(title,0, 0, 2, 1);

        Label product = new Label("Продукт");
        product.setFont(fontBig);
        root.add(product, 0, 1);

        ObservableList<String> options = FXCollections.observableArrayList(
               "Варенная колбаса", "Индейка", "Омлет", "Вафли", "Вишня", "Огурцы");
        ComboBox <String> comboBox = new ComboBox <> (options);
        comboBox.setPrefSize(350, 42);
        comboBox.setStyle("-fx-font-size: 20px");
        root.add(comboBox, 1, 1);

        Label weight = new Label("Вес, г");
        weight.setFont(fontBig);
        root.add(weight, 0, 2);

        TextField valueWeight = new TextField();
        valueWeight.setFont(fontBig);
        root.add(valueWeight, 1, 2);

        Text result = new Text("Результат");
        result.setFont(fontBig);
        root.add(result, 0, 6);

        Button btn = new Button("OK");
        btn.setFont(fontBig);
        btn.setOnAction(actionEvent -> {
            int [] masWes = new int[] {301, 198, 209, 543, 52, 13};
            String mas = valueWeight.getText();

            if (comboBox.getValue() != null) {

                if (mas.matches("[0-9]+")) {
                    String prod = comboBox.getValue();
                    int Index = options.indexOf(prod);
                    int calories100 = masWes[Index];
                    int calories = (Integer.parseInt(mas) / 100) * calories100;
                    result.setText("В " + valueWeight.getText() + " г " + calories + " ккал");
                }
                else {
                    result.setFill(Color.RED);
                    result.setText("Ошибка. Введите вес в граммах");
                }
            }
            else {
            result.setText("Не выбран продукт");
        }
        });
        root.add(btn, 1, 5);
        return root;
    }

    @Override
    public void start(Stage stage) {
        GridPane root = initRootLayout();
        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Приложение");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}