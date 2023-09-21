module com.example.zad24 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zad24 to javafx.fxml;
    exports com.example.zad24;
}