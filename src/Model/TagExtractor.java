package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TagExtractor {

    TreeMap<String, Integer> tagFrequencies;
    TreeSet<String> stopWords;
    File stopWordsFile;
    File SourceFile;

    public TagExtractor() {
        tagFrequencies = new TreeMap<>();
        stopWords = new TreeSet<>();
    }

    public void setStopWordsFile(File stopWordsFile){
        this.stopWordsFile = stopWordsFile;
        try {
            Scanner in = new Scanner(stopWordsFile);
            while (in.hasNext())
                stopWords.add(in.next().toLowerCase());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setSourceFile(File sourceFile){
        this.SourceFile = sourceFile;
    }

    public TreeMap<String, Integer> getTagFrequencies() {
        return tagFrequencies;
    }

    public String getTagFrequenciesString() {
        return tagFrequencies.toString();
    }

    public void process() {
        try {
            Scanner in = new Scanner(SourceFile);
            // Use any characters other than a-z or A-Z or ' as delimiters
            in.useDelimiter("[^a-zA-Z']+");
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                if (!stopWords.contains(word)) {
                    if (tagFrequencies.containsKey(word))
                        tagFrequencies.put(word, tagFrequencies.get(word) + 1);
                    else
                        tagFrequencies.put(word, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
