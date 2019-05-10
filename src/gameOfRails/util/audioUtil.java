package gameOfRails.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class audioUtil {

    static Media cartSound = new Media(new File("audio/cart.aiff").toURI().toString());
    static Media orbSound;
    static Media yesSound;
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
    public static Media getOrbSound() { return orbSound; }
    public static Media getYesSound() { return yesSound; }
}
