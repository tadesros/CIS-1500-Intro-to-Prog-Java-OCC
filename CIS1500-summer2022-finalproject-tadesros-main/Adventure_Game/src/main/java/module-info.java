module com.example.adventure_game {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.adventure_game to javafx.fxml;
    exports com.example.adventure_game;
}