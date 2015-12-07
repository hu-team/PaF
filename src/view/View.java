package view;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View  {
    private BorderPane borderPane;
    private TabPane tabPane;

    public View(Stage stage) {
        //Views
        ViewImpl editorView = new EditorView("Editor", stage);
        ViewImpl selectorView = new SelectorView("Selector");

        //TabPane
        tabPane = new TabPane();
        tabPane.getTabs().addAll(editorView.getTab(), selectorView.getTab());

        //BorderPane
        borderPane = new BorderPane();
        borderPane.setTop(MenuBarView.getMenuBarView());
        borderPane.setCenter(tabPane);

        //Stage
        stage.setTitle("CoProCo");
        stage.setScene(new Scene(borderPane, 800,600));
        stage.show();
    }
}
