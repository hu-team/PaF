package view;

import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class SelectorView implements ViewImpl {
    private String name;
    private VBox items;
    private Tab tab;

    public SelectorView(String name) {
        this.name = name;
        items = new VBox();
        tab = new Tab(name);
        tab.setClosable(false);
    }

    @Override
    public VBox viewItems() {
        return items;
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
