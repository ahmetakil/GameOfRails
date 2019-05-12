package gameOfRails.util;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class audioUtil {


    private static Media cartSound = new Media(new File("audio/cart.aiff").toURI().toString());
    private static Media inGameMusic = new Media(new File("audio/inGameMusic.aiff").toURI().toASCIIString());
    private static Media entryMusic = new Media(new File("audio/entryMusic.aiff").toURI().toString());
    private static MediaPlayer cartPlayer = new MediaPlayer(cartSound);
    private static MediaPlayer entryPlayer = new MediaPlayer(entryMusic);
    private static MediaPlayer gamePlayer = new MediaPlayer(inGameMusic);
    private static boolean isMuted = false;
    static StringProperty muteText = new SimpleStringProperty("MUTE");

    private static void play(MediaPlayer mediaPlayer) {
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }


    private static void stop(MediaPlayer mediaPlayer) {
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


    static void mute() {

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
        muteText.set(isMuted ? "UNMUTE" : "MUTE");

    }
}
