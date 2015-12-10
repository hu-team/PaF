package view;

import controller.SelectorController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Model;
import model.Pattern;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class SelectorView implements ViewImpl {
    private String name;
    private VBox items, v1, v2, v3, v4, v5, imgbox, leftbox;
    private List<VBox> vBoxes = new ArrayList<VBox>();
    private List<Label> labels = new ArrayList<Label>();
    private Tab tab;
    private Model model;
    private HBox mainbox = new HBox();

    public SelectorView(String name, Model model) {
        this.name = name;
        this.model = model;
        items = new VBox();
        leftbox = new VBox();
        tab = new Tab(name);
        tab.setContent(this.viewItems());
        tab.setClosable(false);
    }

    @Override
    public VBox viewItems() {
        ChoiceBox cb = new ChoiceBox();

        cb.setItems(model.getPatternsByName());
        leftbox.getChildren().addAll(cb);

        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                SelectorController sc = new SelectorController();

                int index = newValue.intValue();
                sc.setLabel(getLabels(), index, model);
            }
        });

        for(VBox box : getVBoxes()) {
            leftbox.getChildren().add(box);
        }

        mainbox.getChildren().addAll(leftbox, getImageBox());
        items.getChildren().addAll(mainbox);
        items.setPadding(new Insets(10,10,10,10));
        items.setSpacing(30);

        return items;
    }

    public List<Label> getLabels() {
        //VBox 1 [Name]
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

        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(label8);
        labels.add(label9);
        labels.add(label10);

        return labels;
    }

    public List<VBox> getVBoxes() {
        v1 = new VBox();
        v2 = new VBox();
        v3 = new VBox();
        v4 = new VBox();
        v5 = new VBox();


        //VBox 1 [Name]
        v1.getChildren().addAll(getLabels().get(0), getLabels().get(1));

        //VBox 2 [Context]
        v2.getChildren().addAll(getLabels().get(2), getLabels().get(3));

        //VBox 3 [Problem]
        v3.getChildren().addAll(getLabels().get(4), getLabels().get(5));

        //VBox 4 [Consequences]
        v4.getChildren().addAll(getLabels().get(6), getLabels().get(7));

        //VBox 5 [Solution]
        v5.getChildren().addAll(getLabels().get(8), getLabels().get(9));

        vBoxes.add(v1);
        vBoxes.add(v2);
        vBoxes.add(v3);
        vBoxes.add(v4);
        vBoxes.add(v5);
        //vBoxes.add(v6);

        return vBoxes;
    }

    public VBox getImageBox() {
        imgbox = new VBox();
        Label testlab = new Label("Naam");

        imgbox.getChildren().addAll(testlab);
        imgbox.setAlignment(Pos.CENTER_RIGHT);
        imgbox.setPadding(new Insets(20,20,20,100));

        //Label 6 [Image]
        //imgbox.getChildren().addAll();

        return imgbox;
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
