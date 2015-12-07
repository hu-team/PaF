package view;


import com.sun.tools.javac.comp.Check;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
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
        CheckMenuItem menuItemB = new CheckMenuItem("Editor");
        CheckMenuItem menuItemC = new CheckMenuItem("Selector");
        // Defaults for checked menuItem (Editor is default)
        menuItemB.setSelected(true);
        menuItemC.setSelected(false);
        menuFile1.getItems().addAll(menuItemB, menuItemC);

        menuBar.getMenus().addAll(menuFile,menuFile1);

        menuItemB.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuItemB.setSelected(true);
                menuItemC.setSelected(false);

                System.out.println("yo editor");
                root.setCenter(editorview.items());


            }
        });

        menuItemC.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuItemB.setSelected(false);
                menuItemC.setSelected(true);

                System.out.println("yo selector");
                root.setCenter(selectorview.items());


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

    private static CheckMenuItem createMenuItem(String title/*, final Node node*/) {
        CheckMenuItem cmi = new CheckMenuItem(title);
        cmi.setSelected(true);
        cmi.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue ov,
                                Boolean old_val, Boolean new_val) {
                // node.setVisible(new_val);
            }
        });
        return cmi;
    }

}
