package org.example.applemusic;
import java.util.ArrayList;
import java.util.List;

// Интерфейс для оповещения об изменениях в состоянии проигрывания музыки
interface MusicObserver {
    void onMusicPlay();
    void onMusicPause();
}

// Класс, представляющий проигрыватель музыки
class MusicPlayer {
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
        System.out.println("Music is playing.");
        notifyObserversPlay();
    }

    public void pause() {
        System.out.println("Music is paused.");
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
}
