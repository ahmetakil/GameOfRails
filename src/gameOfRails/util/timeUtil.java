package gameOfRails.util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class timeUtil {
    static long begin;
    static long time;
    static Timeline clock;

    //This methods takes initial time
    public static void startTimer(){
        begin = System.currentTimeMillis();
    }

    /*
    This method takes difference of current time and beginning time and converts
    it into the seconds and minutes with dividing the miliseconds and returns string
    as a clock format.
     */
    public static String currentTime(){
        time = System.currentTimeMillis() - begin;

        long seconds = time/1000;
        long minutes = seconds/60;
        return String.format("%02d:%02d",minutes,seconds%60);
    }

    /*
    This method creates a timeline which is update itself in every seconds. In every update
    it sets the text to current time
     */
    public static void updateTime(Text text){
        clock = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            text.setText(currentTime());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    //Stops the timer
    public static void stopTime(){
        clock.stop();
    }
}
