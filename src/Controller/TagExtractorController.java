package Controller;

import Model.TagExtractor;
import View.TagExtractorGUI;

import javax.swing.*;
import java.io.File;

public class TagExtractorController {
    private TagExtractor tagExtractor;
    private TagExtractorGUI gui;

    public TagExtractorController(TagExtractor tagExtractor, TagExtractorGUI gui) {
        this.tagExtractor = tagExtractor;
        this.gui = gui;

        // Add action listeners to the buttons
        gui.setProcessButton(e -> {
            tagExtractor.process();
            gui.setFrequencyTextArea(tagExtractor.getTagFrequenciesString());

        });

        gui.setChooseStopWordsFileButton(e -> {
            JFileChooser chooser = new JFileChooser();

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                tagExtractor.setStopWordsFile(selectedFile);
                gui.setStopWordsFileNameLabel(selectedFile.getName());
            }
        });

        gui.setChooseSourceFileButton(e -> {
            JFileChooser chooser = new JFileChooser();

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                tagExtractor.setSourceFile(selectedFile);
                gui.setSourceFileNameLabel(selectedFile.getName());
            }

        });
    }
}
