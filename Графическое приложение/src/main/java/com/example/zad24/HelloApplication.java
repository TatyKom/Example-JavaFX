package com.example.zad24;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private final ObservableList<Worker> data = FXCollections.observableArrayList(
            new Worker("Иванов И.И.",35,"Высшее", "Инженер",35000),
            new Worker("Петров С.Н.",45,"Среднее специальное", "водитель",25000));
    private final TableView<Worker> tableDataView = new TableView<>();
    private void createTableView() {

        TableColumn<Worker, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setMinWidth(170);

        TableColumn<Worker, String> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageCol.setMinWidth(100);

        TableColumn<Worker, String> educationCol = new TableColumn<>("Education");
        educationCol.setCellValueFactory(new PropertyValueFactory<>("education"));
        educationCol.setMinWidth(170);

        TableColumn<Worker, String> professionCol = new TableColumn<>("Profession");
        professionCol.setCellValueFactory(new PropertyValueFactory<>("profession"));
        professionCol.setMinWidth(140);

        TableColumn<Worker, String> salaryCol = new TableColumn<>("Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        salaryCol.setMinWidth(100);

        tableDataView.getColumns().setAll(nameCol, ageCol, educationCol, professionCol, salaryCol);
    }
    private void handleButtonEdit() {
        Worker worker = tableDataView.getSelectionModel().getSelectedItem();
        if (worker != null) {
            WorkerEditDialog orgEditDialog = new WorkerEditDialog (worker);
        }
    }
    private void handleButtonAdd() {
        Worker worker = new Worker("", 0, "", "", 0);
        WorkerEditDialog orgEditDialog = new WorkerEditDialog(worker);
        if (orgEditDialog.getResult() == ButtonType.OK) {
            data.add(worker);
        }
    }

    private void handleButtonDelete() {
        int selectedIndex = tableDataView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableDataView.getItems().remove(selectedIndex);
        }
    }
    private Menu createEditMenu() {
        Menu editMenu = new Menu("Edit");
        MenuItem edit = new MenuItem("Edit");
        editMenu.getItems().add(edit);
        edit.setOnAction((ActionEvent event) -> handleButtonEdit());
        MenuItem add = new MenuItem("Add");
        editMenu.getItems().add(add);
        add.setOnAction((ActionEvent event) -> handleButtonAdd());
        MenuItem delete = new MenuItem("Delete");
        editMenu.getItems().add(delete);
        delete.setOnAction((ActionEvent event) -> handleButtonDelete());
        return editMenu;
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("List of workers");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));

        createTableView();
        tableDataView.setItems(data);
        root.setCenter(tableDataView);

        root.setTop(new MenuBar(createEditMenu()));

        Scene scene = new Scene(root, 700, 300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}