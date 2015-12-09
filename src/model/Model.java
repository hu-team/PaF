package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Pattern> patternList;
    private List<String> patternByName;
    private ObservableList<String> observablePatterns;

    public Model() {
        patternList = new ArrayList<Pattern>();
        patternByName = new ArrayList<String>();
        observablePatterns = FXCollections.observableList(patternByName);
    }

    public void save(Pattern pattern) {
        patternList.add(pattern);
        observablePatterns.add(pattern.getName());
    }

    public ObservableList<String> getPatternsByName() {
        return  observablePatterns;
    }

    public List<Pattern> getPatterns() {
        return patternList;
    }

}
