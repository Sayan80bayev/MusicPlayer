package org.example.applemusic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MusicPlayerApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("music_player.fxml"));
        Parent root = loader.load();
        
        MusicPlayerController musicPlayerController = loader.getController();
        
        musicPlayerController.addObserver(new MusicObserver() {
            @Override
            public void onMusicPlay() {
                // Выключаем кнопку play, включаем кнопку pause
                musicPlayerController.getPlay().setDisable(true);
                musicPlayerController.getPause().setDisable(false);
            }

            @Override
            public void onMusicPause() {
                // Выключаем кнопку pause, включаем кнопку play
                musicPlayerController.getPlay().setDisable(false);
                musicPlayerController.getPause().setDisable(true);
            }
        });
        
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Music Player");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
