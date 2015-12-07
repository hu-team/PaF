import javafx.application.Application;
import javafx.stage.Stage;
import view.View;

public class Bootstrap extends Application {
    View view;
    public static void main(String args[]) {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        view = new View(stage);
    }
}
