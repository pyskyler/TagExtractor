package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TagExtractorGUI extends JFrame {

    private JPanel mainPanel;
    private JTextArea frequencyTextArea;
    private JButton processButton;
    private JButton chooseStopWordsFileButton;
    private JButton chooseSourceFileButton;
    private JLabel stopWordsFileNameLabel;
    private JLabel sourceFileNameLabel;

    public TagExtractorGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Frequency Processor");
        setSize(600, 500);


        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        FileChooserPanel();

        frequencyTextArea = new JTextArea(10, 30);
        frequencyTextArea.setLineWrap(true);
        frequencyTextArea.setWrapStyleWord(true);
        frequencyTextArea.setEditable(false);
        frequencyTextArea.setFont(new Font("Avenir", Font.PLAIN, 16));

        JScrollPane frequencyScrollPane = new JScrollPane(frequencyTextArea);

        mainPanel.add(frequencyScrollPane);

        add(mainPanel);
    }

    private void FileChooserPanel() {

        JPanel fileChooserPanel = new JPanel();
        fileChooserPanel.setLayout(new BoxLayout(fileChooserPanel, BoxLayout.Y_AXIS));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 2));

        chooseStopWordsFileButton = new JButton("Choose Stop Words File");
        chooseSourceFileButton = new JButton("Choose Source File");

        stopWordsFileNameLabel = new JLabel();
        stopWordsFileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sourceFileNameLabel = new JLabel();
        sourceFileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        buttonsPanel.add(chooseStopWordsFileButton);
        buttonsPanel.add(chooseSourceFileButton);
        buttonsPanel.add(stopWordsFileNameLabel);
        buttonsPanel.add(sourceFileNameLabel);

        fileChooserPanel.add(buttonsPanel);

        processButton = new JButton("Process File");
        processButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        fileChooserPanel.add(processButton);

        mainPanel.add(fileChooserPanel, BorderLayout.NORTH);
    }

    public void setFrequencyTextArea(String text) {
        frequencyTextArea.setText(text);
    }

    public void setProcessButton(ActionListener actionListener) {
        processButton.addActionListener(actionListener);
    }

    public void setStopWordsFileNameLabel(String text) {
        stopWordsFileNameLabel.setText(text);
    }

    public void setSourceFileNameLabel(String text) {
        sourceFileNameLabel.setText(text);
    }

    public void setChooseStopWordsFileButton(ActionListener actionListener) {
        chooseStopWordsFileButton.addActionListener(actionListener);
    }

    public void setChooseSourceFileButton(ActionListener actionListener) {
        chooseSourceFileButton.addActionListener(actionListener);
    }





}
