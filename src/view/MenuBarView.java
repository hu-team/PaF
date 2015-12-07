package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarView {

    public MenuBarView() {

    }

    public static MenuBar getMenuBarView() {

        MenuBar menuBar = new MenuBar();

        // File tab
        Menu menuFile = new Menu("File");
        MenuItem menuItemA = new MenuItem("Save As");
        MenuItem menuItemD = new MenuItem("Import");
        menuFile.getItems().addAll(menuItemA, menuItemD);

        menuBar.getMenus().addAll(menuFile);

        return menuBar;
    }
}
