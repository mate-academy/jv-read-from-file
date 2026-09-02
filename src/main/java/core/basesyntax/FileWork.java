package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> sentence;
        try {
            sentence = Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }
        StringBuilder builder = new StringBuilder();
        for (String s : sentence) {
            builder.append(s).append(" ");
        }
        String[] clearWords = builder.toString().split("\\W+");
        int length = 0;
        for (String word : clearWords) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                length++;
            }
        }
        String[] filtered = new String[length];
        int counter = 0;
        for (String word : clearWords) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                filtered[counter] = word.toLowerCase();
                counter++;
            }
        }
        Arrays.sort(filtered);
        return filtered;
    }
}
