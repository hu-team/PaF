package view;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View extends Application {
    EditorView editorview = new EditorView();
    SelectorView selectorview = new SelectorView();
    BorderPane root = new BorderPane();

    public static void main(String args[]) {
        Application.launch(args);
    }

    public MenuBar MenuBar() {
        MenuBar menuBar = new MenuBar();

        // File tab
        Menu menuFile = new Menu("File");
        MenuItem menuItemA = new MenuItem("Save As");
        menuFile.getItems().add(menuItemA);

        // View tab
        Menu menuFile1 = new Menu("View");
        MenuItem menuItemB = new MenuItem("Editor");
        MenuItem menuItemC = new MenuItem("Selector");
        menuFile1.getItems().addAll(menuItemB, menuItemC);

        menuBar.getMenus().addAll(menuFile,menuFile1);

        menuFile1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("yo");
                root.setCenter(editorview.items());
            }
        });

        return menuBar;
    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("PaF");


        root.setTop(this.MenuBar());
        root.setCenter(selectorview.items());

        Scene scene = new Scene(root, 800,600);
        primaryStage.setScene(scene);


        primaryStage.show();
    }

}
