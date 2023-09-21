module com.example.entercalories {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.entercalories to javafx.fxml;
    exports com.example.entercalories;
}