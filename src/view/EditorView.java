package view;


import controller.PatternController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class EditorView implements ViewImpl{
    private String name;
    private VBox items;
    private List<VBox> content = new ArrayList<VBox>();
    private Tab tab;
    private String filePath;
    private Stage stage;
    private Model model;

    public EditorView(String name, Stage stage, Model model) {
        this.name = name;
        this.stage = stage;
        this.model = model;
        items = new VBox();
        tab = new Tab(name);
        tab.setContent(this.viewItems());
        tab.setClosable(false);
    }

    @Override
    public VBox viewItems() {

        for(VBox box : getContent()) {
            items.getChildren().add(box);
        }

        items.setPadding(new Insets(10, 10, 10, 10));

        items.setSpacing(10);

        return items;
    }

    public List<VBox> getContent() {
        // VBox 1
        VBox v1 = new VBox();
        Label label1 = new Label("Context");
        TextField textField1 = new TextField();
        textField1.setMaxWidth(300);
        v1.getChildren().addAll(label1, textField1);

        // VBox 2
        VBox v2 = new VBox();
        Label label2 = new Label("Problem");
        TextField textField2 = new TextField();
        textField2.setMaxWidth(300);
        v2.getChildren().addAll(label2, textField2);

        // VBox 3
        VBox v3 = new VBox();
        Label label3 = new Label("Solution");
        TextField textField3 = new TextField();
        textField3.setMaxWidth(300);
        v3.getChildren().addAll(label3, textField3);

        // VBox 4
        VBox v4 = new VBox();
        Label label4 = new Label("Diagram");

        Button button1 = new Button("Choose diagram");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose diagram");

        button1.setOnAction((ActionEvent event) -> {

            File file = fileChooser.showOpenDialog(stage);
            try {
                filePath = file.getPath();
            } catch (Exception e) {
                System.out.println("No file selected");
            }
            //Image image = new Image(getClass().getResourceAsStream(filePath));
            //label4.setGraphic(new ImageView(image));
        });

        v4.getChildren().addAll(label4, button1);

        // VBox 5
        VBox v5 = new VBox();
        Label label5 = new Label("Consequences");
        TextField textField4 = new TextField();
        textField4.setMaxWidth(300);
        v5.getChildren().addAll(label5, textField4);

        //VBox 7
        VBox v7 = new VBox();
        Label label6 = new Label("Name");
        TextField textField5 = new TextField();
        textField5.setMaxWidth(300);
        v7.getChildren().addAll(label6, textField5);

        // VBox 6
        VBox v6 = new VBox();
        Button save = new Button("Save Pattern");
        v6.getChildren().addAll(save);
        save.setOnAction((ActionEvent event) -> {
            List<TextField> tmpList = new ArrayList<TextField>();

            TextField tmpfile = new TextField(filePath);
            tmpList.add(textField1);
            tmpList.add(textField2);
            tmpList.add(textField3);
            tmpList.add(textField4);
            tmpList.add(tmpfile);
            tmpList.add(textField5);

            PatternController patternController = new PatternController(tmpList, model);
            this.clearTextfields(tmpList);
        });

        content.add(v7);
        content.add(v1);
        content.add(v2);
        content.add(v3);
        content.add(v4);
        content.add(v5);
        content.add(v6);

        return content;
    }

    public void clearTextfields(List<TextField> textFields) {
        for(TextField t: textFields) {
            t.setText("");
        }
    }

    @Override
    public Tab getTab() {
        return tab;
    }
}
