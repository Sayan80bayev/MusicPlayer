module org.example.applemusic {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.applemusic to javafx.fxml;
    exports org.example.applemusic;
}