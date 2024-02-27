package org.example.applemusic;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// Интерфейс для оповещения об изменениях в состоянии проигрывания музыки
interface MusicObserver {
    void onMusicPlay();
    void onMusicPause();
}

// Класс, представляющий проигрыватель музыки   
public class MusicPlayerController{
    private MediaPlayer mediaPlayer;
    @FXML
    Button play;

    @FXML
    Button pause;
    // private MusicPlayOnline musicPlayOnline = new MusicPlayOnline();
    
    @FXML
    private Label status;
    private List<MusicObserver> observers = new ArrayList<>();

    // Добавление наблюдателя
    public void addObserver(MusicObserver observer) {
        observers.add(observer);
    }

    // Удаление наблюдателя
    public void removeObserver(MusicObserver observer) {
        observers.remove(observer);
    }

    // Методы для управления проигрыванием музыки
    public void play() {
        setMediaFile();
        status.setText("Music is playing.");
        notifyObserversPlay();
    }

    public void pause() {
        status.setText("Music is paused.");
        notifyObserversPause();
    }

    // Оповещение всех наблюдателей о начале проигрывания музыки
    private void notifyObserversPlay() {
        for (MusicObserver observer : observers) {
            observer.onMusicPlay();
        }
    }

    // Оповещение всех наблюдателей о паузе в проигрывании музыки
    private void notifyObserversPause() {
        for (MusicObserver observer : observers) {
            observer.onMusicPause();
        }  
    }
    public void setMediaFile(String filePath) {
        Media media = new Media(new File(filePath).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.stop();
            status.setText("Music has finished.");
            notifyObserversPause();
        });
    }
    public Button getPlay() {
        return this.play;
    }

    public void setPlay(Button play) {
        this.play = play;
    }

    public Button getPause() {
        return this.pause;
    }

    public void setPause(Button pause) {
        this.pause = pause;
    }
}
