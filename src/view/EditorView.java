package view;


import controller.PatternController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class EditorView implements ViewImpl{
    private String name;
    private VBox items;
    private Tab tab;
    private String filePath;
    private Stage stage;
    private Model model;
    private TextField textField1, textField2, textField3, textField4, textField5;
    private Label label1, label2, label3, label4, label5, label6, path;
    private PatternController patternController;

    public EditorView(String name, Stage stage, Model model) {
        this.name = name;
        this.stage = stage;
        this.model = model;
        items = new VBox();
        tab = new Tab(name);
        patternController = new PatternController(model);
        this.initObj();
        tab.setContent(this.viewItems());
        tab.setClosable(false);
    }

    public void initObj() {
        textField1 = new TextField(); // Naam
        textField2 = new TextField(); // Context
        textField3 = new TextField(); // Problem
        textField4 = new TextField(); // Consequences
        textField5 = new TextField(); // Solution

        label1 = new Label("Name");
        label2 = new Label("Context");
        label3 = new Label("Problem");
        label4 = new Label("Consequences");
        label5 = new Label("Diagram");
        label6 = new Label("Solution");

        // Label next to Choose diagram button
        path = new Label();
    }

    @Override
    public VBox viewItems() {

        for(VBox box : getVBoxes()) {
            items.getChildren().add(box);
        }

        items.setPadding(new Insets(10, 10, 10, 10));

        items.setSpacing(10);

        return items;
    }

    public List<Button> getButtons() {
        List<Button> buttons = new ArrayList<>();

        Button button1 = new Button("Choose diagram");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose diagram");

        Button save = new Button("Save Pattern");

        //Button actions
        button1.setOnAction((ActionEvent event) -> {

            File file = fileChooser.showOpenDialog(stage);
            try {
                filePath = file.getPath();
            } catch (Exception e) {
                System.out.println("No file selected");
            }

            getLabels().get(6).setText(filePath);

            //Image image = new Image(getClass().getResourceAsStream(filePath));
            //label4.setGraphic(new ImageView(image));
        });

        save.setOnAction((ActionEvent event) -> {
            List<TextField> tmpList = new ArrayList<>();

            TextField tmpfile = new TextField(filePath);
            tmpList.add(getTextfields().get(0));
            tmpList.add(getTextfields().get(1));
            tmpList.add(getTextfields().get(2));
            tmpList.add(getTextfields().get(3));
            tmpList.add(tmpfile);
            tmpList.add(getTextfields().get(4));

            patternController.savePattern(tmpList);
            this.clearTextfields(tmpList);
        });

        buttons.add(button1);
        buttons.add(save);

        return buttons;
    }

    public List<Label> getLabels() {
        List<Label> labels = new ArrayList<>();

        // Order important
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(path);

        for (int i = 0 ; i < 6 ; i++) {
            labels.get(i).setStyle("-fx-font-weight: bold;");
        }

        return labels;
    }

    public List<TextField> getTextfields() {
        List<TextField> textFields = new ArrayList<>();

        textFields.add(textField1);
        textFields.add(textField2);
        textFields.add(textField3);
        textFields.add(textField4);
        textFields.add(textField5);

        for(TextField field : textFields) {
            field.setMaxWidth(300);
        }

        return textFields;
    }

    public List<VBox> getVBoxes() {
        List<VBox> vBoxes = new ArrayList<>();

        VBox v1 = new VBox();
        VBox v2 = new VBox();
        VBox v3 = new VBox();
        VBox v4 = new VBox();
        VBox v5 = new VBox();
        VBox v6 = new VBox();
        VBox v7 = new VBox();

        //VBox 1 [Name]
        v1.getChildren().addAll(getLabels().get(0), getTextfields().get(0));

        //VBox 2 [Context]
        v2.getChildren().addAll(getLabels().get(1), getTextfields().get(1));

        //VBox 3 [Problem]
        v3.getChildren().addAll(getLabels().get(2), getTextfields().get(2));

        //VBox 4 [Consequences]
        v4.getChildren().addAll(getLabels().get(3), getTextfields().get(3));

        //VBox 5 [Diagram]
        v5.getChildren().addAll(getLabels().get(4), getButtons().get(0), getLabels().get(6));

        //VBox 6 [Solution]
        v6.getChildren().addAll(getLabels().get(5), getTextfields().get(4));

        //VBox 7 [Save]
        v7.getChildren().addAll(getButtons().get(1));

        vBoxes.add(v1);
        vBoxes.add(v2);
        vBoxes.add(v3);
        vBoxes.add(v4);
        vBoxes.add(v5);
        vBoxes.add(v6);
        vBoxes.add(v7);

        return vBoxes;
    }


    public void clearTextfields(List<TextField> textFields) {
        for(TextField t: textFields) {
            t.setText("");
        }
        getLabels().get(6).setText("");
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
