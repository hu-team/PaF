package controller;

import javafx.scene.control.Label;
import model.Model;
import model.Pattern;

import java.util.List;

public class SelectorController {
    public void setLabel(List<Label> labels, int index, Model model) {
         List<Pattern> patterns = model.getPatterns();
         Pattern pattern = patterns.get(index);

        labels.get(1).setText(pattern.getName());
        labels.get(3).setText(pattern.getContext());
        labels.get(5).setText(pattern.getProblem());
        labels.get(7).setText(pattern.getConsequences());
        labels.get(9).setText(pattern.getSolution());
    }
}
