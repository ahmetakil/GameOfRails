import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {


    final int SIZE = 430;

    public static void main(String[] args) {


        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        Random random = new Random(); //Obje var
        primaryStage.setTitle("Marmaray Puzzle game from TCDD");
        GridPane gridPane = new GridPane();
        // gridPane.setFocusTraversable(true);

        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);


        Scene scene = new Scene(gridPane, SIZE, SIZE);
        Rectangle[][] rectangles = new Rectangle[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Rectangle temp = new Rectangle(100, 100);


                temp.setStroke(Color.BLACK);
                temp.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                temp.setOnMouseClicked(e -> {

                    System.out.println(GridPane.getRowIndex(e.getPickResult().getIntersectedNode())+ "  , " + GridPane.getColumnIndex(e.getPickResult().getIntersectedNode()));

                });
                temp.widthProperty().bind(scene.widthProperty().divide(4).subtract(7));
                temp.heightProperty().bind(scene.heightProperty().divide(4).subtract(7));
                gridPane.add(temp, i, j);
                rectangles[i][j] = temp;

            }
        }


        primaryStage.setScene(scene);
        primaryStage.show();

    }
}