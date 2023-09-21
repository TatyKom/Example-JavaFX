package com.example.zad24;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WorkerEditDialog {
    private final Worker org;
    private final Stage dialog;
    private TextField nameEdit;
    private Spinner<Integer> ageEdit;
    private ComboBox<String> educationEdit;
    private TextField professionEdit;
    private Spinner<Double> salaryEdit;
    private final Font font;
    private final GridPane root;
    private ButtonType result = ButtonType.CANCEL;
    private void createNameText(){
        Label nameOrg = new Label("Name: ");
        nameOrg.setFont(font);
        root.add(nameOrg, 0, 0);
        nameEdit = new TextField();
        nameEdit.setFont(Font.font(24));
        nameEdit.setText(org.getName());
        root.add(nameEdit, 1,0);
        Label professionOrg = new Label("Profession: ");
        professionOrg.setFont(font);
        root.add(professionOrg, 0, 3);
        professionEdit = new TextField();
        professionEdit.setFont(Font.font(24));
        professionEdit.setText(org.getProfession());
        root.add(professionEdit, 1,3);
    }
    private void createSpinner() {
        Label ageOrg = new Label("Age:");
        ageOrg.setFont(font);
        root.add(ageOrg, 0, 1);
        ageEdit = new Spinner<>(1, 100, org.getAge());
        ageEdit.setStyle("-fx-font-size: 24 pt");
        ageEdit.setEditable(true);
        root.add(ageEdit, 1, 1);
        Label salaryOrg = new Label("Salary:");
        salaryOrg.setFont(font);
        root.add(salaryOrg, 0, 4);
        salaryEdit = new Spinner<>(0, 200000, org.getSalary(), 0.01);
        salaryEdit.setStyle("-fx-font-size: 24 pt");
        salaryEdit.setEditable(true);
        root.add(salaryEdit, 1, 4);
    }
    private void createComboBox() {
        Label educationOrg = new Label("Education:");
        educationOrg.setFont(font);
        root.add(educationOrg, 0, 2);
        educationEdit = new ComboBox<>();
        educationEdit.setStyle("-fx-font-size: 24 pt");
        educationEdit.getItems().addAll(
                "Общее",
                "Высшее",
                "Среднее специальное"
        );
        educationEdit.setValue(org.getEducation());
        root.add(educationEdit, 1, 2);
    }
    private void createButtons() {
        Button btnOk = new Button("Ok");
        btnOk.setFont(Font.font(24));
        root.add(btnOk, 0, 5);
        btnOk.setOnAction((ActionEvent e) -> handleOk());
        Button btnCancel = new Button("Cancel");
        btnCancel.setFont(Font.font(24));
        root.add(btnCancel, 1, 5);
        btnCancel.setOnAction((ActionEvent e) -> handleCancel());
    }
    public WorkerEditDialog (Worker org) {
        this.org = org;
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Edit organization");
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        font = Font.font("Tahoma", FontWeight.NORMAL, 20);
        createNameText();
        createSpinner();
        createComboBox();
        createButtons();
        Scene scene = new Scene(root, 600, 500);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
    private void handleOk() {
        org.setName(nameEdit.getText());
        org.setAge(ageEdit.getValue());
        org.setEducation(educationEdit.getValue());
        org.setProfession(professionEdit.getText());
        org.setSalary(salaryEdit.getValue());
        result = ButtonType.OK;
        dialog.close();
    }

    private void handleCancel() {
        result = ButtonType.CANCEL;
        dialog.close();
    }

    public ButtonType getResult() {
        return result;
    }
}
