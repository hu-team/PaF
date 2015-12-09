package view;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import model.Model;
import model.Pattern;

public class SelectorView implements ViewImpl {
    private String name;
    private VBox items;
    private Tab tab;
    private Model model;

    public SelectorView(String name, Model model) {
        this.name = name;
        this.model = model;
        items = new VBox();
        tab = new Tab(name);
        tab.setContent(this.viewItems());
        tab.setClosable(false);
    }

    @Override
    public VBox viewItems() {
        ChoiceBox cb = new ChoiceBox();

        cb.setItems(model.getPatternsByName());

        items.getChildren().addAll(cb);

        return items;
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
