package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Pattern> patterns;

    public Model() {
        patterns = new ArrayList<Pattern>();
    }

    public void save(Pattern pattern) {
        patterns.add(pattern);
    }

    public List<Pattern> getPatterns() {
        return  patterns;
    }
}
