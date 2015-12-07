package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.List;

public class MenuBarView {

    public MenuBarView() {

    }

    public static MenuBar getMenuBarView(List<ViewImpl> lov) {

        MenuBar menuBar = new MenuBar();

        // File tab
        Menu menuFile = new Menu("File");
        MenuItem menuItemA = new MenuItem("Save As");
        MenuItem menuItemD = new MenuItem("Import");
        menuFile.getItems().addAll(menuItemA, menuItemD);

        // View tab
        Menu menuFile1 = new Menu("View");
        CheckMenuItem menuItemB = new CheckMenuItem("Editor");
        CheckMenuItem menuItemC = new CheckMenuItem("Selector");
        // Defaults for checked menuItem (Editor is default)
        menuItemB.setSelected(true);
        menuItemC.setSelected(false);
        menuFile1.getItems().addAll(menuItemB, menuItemC);

        menuBar.getMenus().addAll(menuFile,menuFile1);

        menuItemB.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuItemB.setSelected(true);
                menuItemC.setSelected(false);

                ViewImpl tmpview = lov.get(0);
                ViewImpl tmpview2 = lov.get(1);


                if(tmpview.isVisible()) {
                    tmpview.hide();
                    tmpview2.show();
                } else {
                    tmpview.show();
                    tmpview2.hide();
                }

                System.out.println("yo editor");
                //  root.setCenter(editorview.items());


            }
        });

        menuItemC.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuItemB.setSelected(false);
                menuItemC.setSelected(true);

                ViewImpl tmpview = lov.get(1);
                ViewImpl tmpview2 = lov.get(0);

                if(tmpview.isVisible()) {
                    tmpview.hide();
                    tmpview2.show();
                } else {
                    tmpview.show();
                    tmpview2.hide();
                }

                System.out.println("yo selector");
                //   root.setCenter(selectorview.items());


            }
        });

        return menuBar;

}
}
