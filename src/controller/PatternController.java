package controller;


import javafx.scene.control.TextField;
import model.Model;
import model.Pattern;
import java.util.List;

public class PatternController {
    private Model model;

    public PatternController(List<TextField> textField, Model model) {
        this.model = model;
        this.savePattern(textField);
    }

    public void savePattern(List<TextField> txtfield) {
        String txt1 = txtfield.get(0).getText();
        Pattern pattern = new Pattern(txt1);
        //Pattern pattern = new Pattern((String) txtfield.get(0).getText(), (String) txtfield.get(1).getText(), (String) txtfield.get(2).getText(), (String) txtfield.get(3).getText());
        model.save(pattern);
        //System.out.println("Aantal Pattern: " + model.getPatterns().size());

    }
}
