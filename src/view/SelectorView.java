package view;

import controller.SelectorController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import model.Model;
import model.Pattern;

import java.util.ArrayList;
import java.util.List;

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

        //VBox 1 [Name]
        Label label1 = new Label();

        //VBox 2 [Context]
        Label label2 = new Label();

        items.getChildren().addAll(cb, label1, label2);

        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                SelectorController sc = new SelectorController();
                List<Label> tmplist = new ArrayList<Label>();

                tmplist.add(label1);
                tmplist.add(label2);

                int index = newValue.intValue();
                sc.setLabel(tmplist, index, model);
            }
        });

        return items;
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
