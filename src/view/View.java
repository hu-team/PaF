package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class View extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    public View(String args[]) {

    }



    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PaF");

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 800,600));
        primaryStage.show();
    }
}
