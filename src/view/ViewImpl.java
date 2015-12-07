package view;

import javafx.scene.layout.HBox;

public interface ViewImpl {

    HBox items();
    void show();
    void hide();
    boolean isVisible();
}
