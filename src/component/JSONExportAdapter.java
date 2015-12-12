package component;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Pattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONExportAdapter implements Export {
    private Pattern pattern;
    private Gson saveObj;
    private BufferedWriter output = null;

    public void generate(Pattern pattern) {
        GsonBuilder builder = new GsonBuilder();
        this.saveObj = builder.create();
        this.save(pattern);
    }

    public void save(Pattern pattern) {
        try {
            File file = new File("./export/export-"+pattern.getName()+".json");
            output = new BufferedWriter(new FileWriter(file));
            output.write(saveObj.toJson(pattern));
            output.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }


}
