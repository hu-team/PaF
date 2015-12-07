package view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class View extends Application {
    ViewImpl editorview = new EditorView();
    ViewImpl selectorview = new SelectorView();
    List<ViewImpl> lov = new ArrayList<ViewImpl>();
    HBox centerbox = new HBox();
    BorderPane root = new BorderPane();

    public static void main(String args[]) {
        Application.launch(args);
    }


    public HBox centerapp() {
        centerbox.getChildren().addAll(editorview.items(), selectorview.items());
        return centerbox;
    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("PaF");

        lov.add(editorview);
        lov.add(selectorview);
        
        selectorview.hide();

        root.setTop(MenuBarView.getMenuBarView(lov));
        root.setCenter(centerapp());

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
