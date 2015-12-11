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
        Pattern pattern = new Pattern(txtfield.get(0).getText(), txtfield.get(1).getText(), txtfield.get(2).getText(), txtfield.get(3).getText(), txtfield.get(4).getText(), txtfield.get(5).getText());
        System.out.println(pattern.toString());
        model.save(pattern);
    }
}
