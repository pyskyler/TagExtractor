import Model.TagExtractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class TagExtractorTest {

    @org.junit.jupiter.api.Test
    void process() {
        TagExtractor tagExtractor = new TagExtractor();
        File stopWordsFile = new File("tests/English Stop Words.txt");
        File sourceFile = new File("tests/Test Source");
        try {
            tagExtractor.setStopWordsFile(stopWordsFile);
            tagExtractor.setSourceFile(sourceFile);
            tagExtractor.process();
            TreeMap<String, Integer> tagFrequencies = tagExtractor.getTagFrequencies();
            assertEquals(3, tagFrequencies.get("don't"));
            assertEquals(3, tagFrequencies.get("wanna"));
            assertEquals(1, tagFrequencies.get("forward"));
            assertEquals(1, tagFrequencies.get("cross"));
            assertEquals(2, tagFrequencies.get("crash"));
            assertEquals(null, tagFrequencies.get("if"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}