module org.example.applemusic {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example.applemusic to javafx.fxml;
    exports org.example.applemusic;
}