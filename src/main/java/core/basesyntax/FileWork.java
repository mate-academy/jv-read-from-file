package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builderValidWords = new StringBuilder();
            String wordsFromFile;
            while ((wordsFromFile = reader.readLine()) != null) {
                String[] validWords = wordsFromFile.split("\\W");
                for (String validWord : validWords) {
                    if (validWord.toLowerCase().startsWith(CHARACTER)) {
                        builderValidWords.append(validWord.toLowerCase()).append(" ");
                    }
                }
            }
            if (builderValidWords.length() == 0) {
                return new String[0];
            }
            String[] words = builderValidWords.toString().trim().split(" ");
            Arrays.sort(words);
            return words;
        } catch (IOException e) {
            throw new RuntimeException("Error when the file start reading", e);
        }
    }
}
