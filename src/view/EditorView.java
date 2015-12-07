package view;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class EditorView implements ViewImpl{
    private String name;
    private VBox items;
    private Tab tab;
    private Stage stage;

    public EditorView(String name, Stage stage) {
        this.name = name;
        this.stage = stage;
        items = new VBox();
        tab = new Tab(name);
        tab.setContent(this.viewItems());
        tab.setClosable(false);
    }

    @Override
    public VBox viewItems() {
        //Labels
        Label label1 = new Label("Context");
        Label label2 = new Label("Problem");
        Label label3 = new Label("Solution");
        Label label4 = new Label("Diagram");
        Label label5 = new Label("Consequences");

        //Textfields
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();

        //Button
        Button save = new Button("Save Pattern");
        Button button1 = new Button("Choose diagram");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose diagram");

        button1.setOnAction((ActionEvent event) -> {

            File file = fileChooser.showOpenDialog(stage);
        });

        items.getChildren().addAll(label1, textField1, label2, textField2, label3, textField3, label4, button1, label5, textField4, save);

        return items;
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
