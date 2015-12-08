import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import view.View;

public class Bootstrap extends Application {
    View view;
    Model model;

    public static void main(String args[]) {
        Model model = new Model();
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        view = new View(stage, model);
    }
}
