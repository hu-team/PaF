package view;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

import java.util.List;

public interface ViewImpl {

    VBox viewItems();
    Tab getTab();
    List<Label> getLabels();
    List<VBox> getVBoxes();

    }
