package view;


import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class EditorView {

    public EditorView() {

    }

    public HBox items() {
        HBox box = new HBox();
        TextField txtfield = new TextField();

        box.getChildren().addAll(txtfield);
        return box;
    }
}
