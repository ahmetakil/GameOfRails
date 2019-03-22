import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args){


        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("Test");
        Pane pane = new Pane();
        pane.getChildren().add(label);
        Scene scene = new Scene(pane,500,500);

        primaryStage.setScene(scene);
            primaryStage.show();
    }
}
