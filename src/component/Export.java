package component;

import model.Pattern;

public interface Export {
    void generate(Pattern pattern);
    void save(Pattern pattern);
}
