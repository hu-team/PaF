package controller;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import model.Model;
import model.Pattern;

import java.io.File;
import java.util.List;

public class SelectorController {
    Image image;

    public void setLabel(List<Label> labels, int index, Model model) {
        List<Pattern> patterns = model.getPatterns();
        Pattern pattern = patterns.get(index);

        labels.get(1).setText(pattern.getName());
        labels.get(3).setText(pattern.getContext());
        labels.get(5).setText(pattern.getProblem());
        labels.get(7).setText(pattern.getConsequences());
        labels.get(9).setText(pattern.getSolution());
    }

    public Image getImage(int index, Model model) {
        List<Pattern> patterns = model.getPatterns();
        Pattern pattern = patterns.get(index);

        try {
            File file = new File(pattern.getDiagram());
            image = new Image(file.toURI().toString());
        } catch (Exception e) {
            System.out.println("No image");
        }

        return image;
    }

}
