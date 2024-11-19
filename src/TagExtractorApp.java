import Controller.TagExtractorController;
import Model.TagExtractor;
import View.TagExtractorGUI;

import javax.swing.*;

public class TagExtractorApp {

    public static void main(String[] args) {
        TagExtractorGUI gui = new TagExtractorGUI();
        TagExtractor tagExtractor = new TagExtractor();
        TagExtractorController controller = new TagExtractorController(tagExtractor, gui);

        gui.setVisible(true);
    }
}
