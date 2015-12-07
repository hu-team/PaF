package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SelectorView implements ViewImpl {
    HBox box = new HBox();

    public SelectorView() {

    }

    public HBox items() {
        Label label1 = new Label("Selector view");

        box.getChildren().addAll(label1);
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
