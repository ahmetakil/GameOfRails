package util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class timeUtil {
    static long begin;
    static long time;
    static Timeline clock;
    public static void startTimer(){
        begin = System.currentTimeMillis();
    }


    public static String currentTime(){
        time = System.currentTimeMillis() - begin;

        long seconds = time/1000;
        long minutes = seconds/60;
        return String.format("%02d:%02d",minutes,seconds);
    }

    public static void updateTime(Text text){
        clock = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            text.setText(currentTime());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    public static void stopTime(){
        clock.stop();
    }
}
