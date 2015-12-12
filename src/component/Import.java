package component;


import com.google.gson.stream.JsonReader;
import javafx.scene.control.TextField;

import java.util.List;

public interface Import {
    void open(String filepath);
    void createObj(JsonReader file);
}
