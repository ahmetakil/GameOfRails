package gameOfRails.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class audioUtil {

    static Media cartSound = new Media(new File("audio/cart.aiff").toURI().toString());
    static Media inGameMusic = new Media(new File("audio/inGameMusic.aiff").toURI().toASCIIString());
    static Media entryMusic = new Media(new File("audio/entryMusic.aiff").toURI().toString());
    static MediaPlayer cartPlayer = new MediaPlayer(cartSound);
    static MediaPlayer entryPlayer = new MediaPlayer(entryMusic);
    static MediaPlayer gamePlayer = new MediaPlayer(inGameMusic);
    static boolean isMuted = false;

    public static void play(MediaPlayer mediaPlayer) {
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }


    public static void stop(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
    }

    public static void stopAll(){
        cartPlayer.stop();
        gamePlayer.stop();
        cartPlayer.stop();
    }

    public static void playEntry() {
        play(entryPlayer);
    }

    public static void playCart() {
        play(cartPlayer);
    }

    public static void playGame(){
        play(gamePlayer);
    }


    public static void stopEntry(){
        stop(entryPlayer);
    }

    public static void stopCart(){
        stop(cartPlayer);
    }

    public static void stopGame(){
        stop(gamePlayer);
    }


    public static void mute() {

        if (isMuted) {
            cartPlayer.setMute(false);
            gamePlayer.setMute(false);
            entryPlayer.setMute(false);
            isMuted = false;

        } else {

            cartPlayer.setMute(true);
            gamePlayer.setMute(true);
            entryPlayer.setMute(true);
            isMuted = true;
        }

    }
}
