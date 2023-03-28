module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens Main to javafx.fxml;
    exports Main;
    exports GUI;
    opens GUI to javafx.fxml;
}