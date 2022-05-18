module com.example.gradle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gradle to javafx.fxml;
    exports com.example.gradle;
}