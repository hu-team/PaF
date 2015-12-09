package controller;

import javafx.scene.control.Label;
import model.Model;
import model.Pattern;

import java.util.List;

public class SelectorController {
    public void setLabel(List<Label> labels, int index, Model model) {
         List<Pattern> patterns = model.getPatterns();
         Pattern pattern = patterns.get(index);

        labels.get(0).setText(pattern.getName());
        labels.get(1).setText(pattern.getContext());
    }
}
