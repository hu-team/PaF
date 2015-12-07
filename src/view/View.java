package view;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class View extends Application {
    public static void main(String args[]) {
        Application.launch(args);
    }

    public MenuBar MenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItemA = new MenuItem("Save As");
        Menu menuFile1 = new Menu("View");
        MenuItem menuItemB = new MenuItem("Editor");
        MenuItem menuItemC = new MenuItem("Selector");


        menuFile.getItems().add(menuItemA);
        menuFile1.getItems().addAll(menuItemB, menuItemC);
        menuBar.getMenus().addAll(menuFile,menuFile1);
        return menuBar;
    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("PaF");

        BorderPane root = new BorderPane();
        root.setTop(this.MenuBar());

        Scene scene = new Scene(root, 800,600);
        primaryStage.setScene(scene);


        primaryStage.show();
    }

}
