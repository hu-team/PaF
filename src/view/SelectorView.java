package view;

import controller.SelectorController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Model;

import java.util.ArrayList;
import java.util.List;

public class SelectorView implements ViewImpl {
    private String name;
    private VBox items, v1, v2, v3, v4, v5, leftbox, rightbox;
    private Tab tab;
    private Model model;
    private HBox mainbox = new HBox();
    private ImageView imgview = new ImageView();

    private Label label1, label2, label3, label4, label5,label6,label7,label8,label9,label10;

    public SelectorView(String name, Model model) {
        this.name = name;
        this.model = model;
        items = new VBox();
        leftbox = new VBox();
        rightbox = new VBox();
        this.initObj();
        tab = new Tab(name);
        tab.setContent(this.viewItems());
        tab.setClosable(false);
    }

    public void initObj() {
        //Label 1 [Name]
        label1 = new Label("Naam");
        label2 = new Label("");

        //Label 2 [Context]
        label3 = new Label("Context");
        label4 = new Label("");

        //Label 3 [Problem]
        label5 = new Label("Problem");
        label6 = new Label("");

        //Label 4 [Consequences]
        label7 = new Label("Consequences");
        label8 = new Label("");

        //Label 5 [Solution]
        label9 = new Label("Solution");
        label10 = new Label("");
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
                imgview.setImage(sc.getImage(index, model));
            }
        });

        for(VBox box : getVBoxes()) {
            leftbox.getChildren().add(box);
        }

        imgview.setPreserveRatio(true);
        imgview.setFitWidth(500);
        imgview.setFitHeight(450);

        leftbox.setSpacing(50);

        rightbox.setPadding(new Insets(40, 10, 10, 100));
        rightbox.getChildren().addAll(imgview);

        mainbox.getChildren().addAll(leftbox, rightbox);
        mainbox.setPadding(new Insets(10,10,10,10));

        items.getChildren().addAll(mainbox);
        items.setPadding(new Insets(10,10,10,10));
        items.setSpacing(30);

        return items;
    }

    public List<Label> getLabels() {
        List<Label> labels = new ArrayList<>();

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
        List<VBox> vBoxes = new ArrayList<>();

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

        return vBoxes;
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
