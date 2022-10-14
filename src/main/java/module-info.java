module com.example.mynewapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.mynewapp to javafx.fxml;
    exports com.example.mynewapp;
}