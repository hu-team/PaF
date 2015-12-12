package view;

import component.JSONImportAdapter;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Model;

import java.io.File;

public class MenuBarView {
    //private MenuBarController mbc;
    private JSONImportAdapter jsonia;

    public MenuBarView(Model model) {
        //mbc = new MenuBarController();
        jsonia = new JSONImportAdapter(model);
    }

    public MenuBar getMenuBarView(Stage stage) {

        MenuBar menuBar = new MenuBar();

        // File tab
        Menu menuFile = new Menu("File");
        MenuItem menuItemA = new MenuItem("Save As");
        MenuItem menuItemD = new MenuItem("Import");

        menuItemD.setOnAction((ActionEvent e) -> {
            FileChooser fc = new FileChooser();

            File file = fc.showOpenDialog(stage);
            String filePath;
            try {
                filePath = file.getPath();
                jsonia.open(filePath);

            } catch (Exception ex) {
                System.out.println("No file selected");
            }
        });

        menuFile.getItems().addAll(menuItemA, menuItemD);

        menuBar.getMenus().addAll(menuFile);

        return menuBar;
    }
}
