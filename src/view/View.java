package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class View extends Application {

    public static void main(String args[]) {
        Application.launch(args);
    }

    public MenuBar MenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.getMenus().addAll(menuFile);
        return menuBar;
    }


    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PaF");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800,600);
        primaryStage.setScene(scene);
        root.getChildren().add(this.MenuBar());

        primaryStage.show();
    }

}
