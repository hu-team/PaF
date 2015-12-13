package component;

import com.google.gson.stream.JsonReader;
import controller.PatternController;
import javafx.scene.control.TextField;
import model.Model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JSONImportAdapter implements Import {
    private Model model;
    private PatternController pc;

    private TextField textField1, textField2, textField3, textField4, textField5, textField6;
    JsonReader reader;

    public JSONImportAdapter(Model model) {
        this.model = model;
        this.pc = new PatternController(model);
    }

    @Override
    public void open(String filepath) {
        try {
            reader = new JsonReader(new FileReader(filepath));
        } catch (Exception e) {
            System.out.println("Error: reading import file");
        }
        createObj(reader);
    }

    @Override
    public void createObj(JsonReader file) {
        List<TextField> tmpList = new ArrayList<>();

        textField1 = new TextField(); // Naam
        textField2 = new TextField(); // Context
        textField3 = new TextField(); // Problem
        textField4 = new TextField(); // Consequences
        textField5 = new TextField(); // Diagram
        textField6 = new TextField(); // Solution

        try {
            file.beginObject();

            while (file.hasNext()) {

                String name = file.nextName();

                if (name.equals("name")) {

                    textField1.setText(file.nextString());

                } else if (name.equals("context")) {

                    textField2.setText(file.nextString());

                } else if (name.equals("problem")) {

                    textField3.setText(file.nextString());

                } else if (name.equals("consequences")) {

                    textField4.setText(file.nextString());

                } else if (name.equals("diagram")) {

                    textField5.setText(file.nextString());

                } else if (name.equals("solution")) {

                    textField6.setText(file.nextString());

                } else {
                    file.skipValue(); //avoid some unhandled events
                }
            }

            file.endObject();
            file.close();

        } catch (Exception e) {
            System.out.println("Error: importing file");
        }

        tmpList.add(textField1);
        tmpList.add(textField2);
        tmpList.add(textField3);
        tmpList.add(textField4);
        tmpList.add(textField5);
        tmpList.add(textField6);

        pc.savePattern(tmpList);
    }

}
