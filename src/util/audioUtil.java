package util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class audioUtil {

    public void playAudio(String name) {

        Class c = null;
        try {
            c = Class.forName("Main");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Media media = new Media(c.getResource("audio/" + name).toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

}
