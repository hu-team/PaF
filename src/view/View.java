package view;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Model;

public class View  {
    private BorderPane borderPane;
    private TabPane tabPane;
    private VBox vbox;

    public View(Stage stage, Model model) {
        //Views
        ViewImpl editorView = new EditorView("Editor", stage, model);
        ViewImpl selectorView = new SelectorView("Selector", model);
        MenuBarView menuBarView = new MenuBarView(model);

        //TabPane
        tabPane = new TabPane();
        tabPane.getTabs().addAll(editorView.getTab(), selectorView.getTab());

        // VBox
        vbox = new VBox();
        vbox.getChildren().addAll(menuBarView.getMenuBarView(stage), tabPane);

        //BorderPane
        borderPane = new BorderPane();
        borderPane.setTop(vbox);
        borderPane.setLeft(null);

        //Stage
        stage.setTitle("CoProCo");
        stage.setScene(new Scene(borderPane, 1027,768));
        stage.show();
    }
}
