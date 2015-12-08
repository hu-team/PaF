import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import view.View;

public class Bootstrap extends Application {
    View view;
    Model model;

    public static void main(String args[]) {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        Model model = new Model();
        view = new View(stage, model);
    }
}
