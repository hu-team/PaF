package controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Model;
import model.Pattern;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SelectorController {
    Image image;

    public void setLabel(List<Label> labels, int index, Model model) {
         List<Pattern> patterns = model.getPatterns();
         Pattern pattern = patterns.get(index);

        System.out.println(pattern.toString());

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
