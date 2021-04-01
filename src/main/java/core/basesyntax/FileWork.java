package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader textReader = new BufferedReader(new FileReader(file))) {
            StringBuilder text = new StringBuilder();
            int value = textReader.read();
            while (value != -1) {
                text.append((char) value);
                value = textReader.read();
            }
            String[] words = text.toString().split("[\\W]+");
            StringBuilder filteredWordsList = new StringBuilder();
            for (String word : words) {
                String lowerCaseWord = word.toLowerCase();
                if (lowerCaseWord.startsWith(SPECIFIED_LETTER)) {
                    filteredWordsList.append(lowerCaseWord).append(" ");
                }
            }
            if (filteredWordsList.length() == 0) {
                return new String[0];
            }
            String[] filteredWords = filteredWordsList.toString().split(" ");
            Arrays.sort(filteredWords);
            return filteredWords;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
