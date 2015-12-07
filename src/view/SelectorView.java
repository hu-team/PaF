package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SelectorView {
    public SelectorView() {

    }

    public HBox items() {
        HBox box = new HBox();
        Label label1 = new Label("Selector view");

        box.getChildren().addAll(label1);
        return box;
    }
}
