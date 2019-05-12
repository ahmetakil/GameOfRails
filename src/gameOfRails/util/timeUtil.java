package gameOfRails.util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class timeUtil {
    private static long begin;
    private static Timeline clock;

    //This methods takes initial time
    public static void startTimer(){
        begin = System.currentTimeMillis();
    }

    /*
    This method takes difference of current time and beginning time and converts
    it into the seconds and minutes with dividing the milliseconds and returns string
    as a clock format.
     */
    private static String currentTime(){

        long seconds = currentSeconds();
        long minutes = seconds/60;
        return String.format("%02d:%02d",minutes,seconds%60);
    }

    public static long currentSeconds(){
        return (System.currentTimeMillis() - begin)/1000;
    }

    /*
    This method creates a timeline which is update itself in every seconds. In every update
    it sets the text to current time
     */
    public static void updateTime(Text text){
        clock = new Timeline(new KeyFrame(Duration.seconds(1), e -> text.setText(currentTime())),
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
