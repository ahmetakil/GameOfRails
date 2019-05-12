package gameOfRails.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class audioUtil {

    static Media cartSound = new Media(new File("audio/cart.aiff").toURI().toString());
    static Media inGameMusic = new Media(new File("audio/inGameMusic.aiff").toURI().toASCIIString());
    static Media entryMusic = new Media(new File("audio/entryMusic.aiff").toURI().toString());
    static MediaPlayer mediaPlayer;

    public static void playInLoop(Media media){
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void playOnce(Media media){
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public static void stop(){
        mediaPlayer.stop();
    }



    public static Media getCartSound() { return cartSound; }
    public static Media getInGameMusic() { return inGameMusic; }
    public static Media getEntryMusic() { return entryMusic; }

    public static void Mute(){
        mediaPlayer.setMute(true);


    }
}
