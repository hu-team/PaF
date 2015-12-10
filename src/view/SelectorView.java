package view;

import controller.SelectorController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Model;
import model.Pattern;

import java.util.ArrayList;
import java.util.List;

public class SelectorView implements ViewImpl {
    private String name;
    private VBox items, leftbox, rightbox;
    private List<Label> content = new ArrayList<Label>();
    private Tab tab;
    private Model model;
    private HBox mainbox = new HBox();

    public SelectorView(String name, Model model) {
        this.name = name;
        this.model = model;
        items = new VBox();
        leftbox = new VBox();
        rightbox = new VBox();
        tab = new Tab(name);
        tab.setContent(this.viewItems());
        tab.setClosable(false);
    }

    @Override
    public VBox viewItems() {
        ChoiceBox cb = new ChoiceBox();

        cb.setItems(model.getPatternsByName());



        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                SelectorController sc = new SelectorController();

                int index = newValue.intValue();
                sc.setLabel(getContent(), index, model);
            }
        });

        for(Label lab : getContent()) {
            rightbox.getChildren().add(lab);
        }

        items.setPadding(new Insets(10,10,10,10));
        leftbox.getChildren().addAll(cb);
        mainbox.getChildren().addAll(leftbox, rightbox);
        items.getChildren().add(mainbox);

        return items;
    }

    public List<Label> getContent() {
        //Label 1 [Name]
        Label label1 = new Label("Naam");
        Label label2 = new Label();

        //Label 2 [Context]
        Label label3 = new Label("Context");
        Label label4 = new Label();

        //Label 3 [Problem]
        Label label5 = new Label("Problem");
        Label label6 = new Label();

        //Label 4 [Consequences]
        Label label7 = new Label("Consequences");
        Label label8 = new Label();

        //Label 5 [Solution]
        Label label9 = new Label("Solution");
        Label label10 = new Label();

        content.add(label1);
        content.add(label2);
        content.add(label3);
        content.add(label4);
        content.add(label5);
        content.add(label6);
        content.add(label7);
        content.add(label8);
        content.add(label9);
        content.add(label10);

        return content;
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
