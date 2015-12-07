package view;


import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class EditorView implements ViewImpl{
    HBox box = new HBox();

    public EditorView() {

    }

    public HBox items() {

        TextField txtfield = new TextField();

        box.getChildren().addAll(txtfield);
        return box;
    }

    public void show() {
        box.setVisible(true);
    }

    public void hide() {
        box.setVisible(false);
    }

    public boolean isVisible() {
        if(box.isVisible()) {
            return true;
        }

        return false;
    }
}
