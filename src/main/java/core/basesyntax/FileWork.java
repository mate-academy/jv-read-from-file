package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String SEARCH_LETTER = "w";

    public String[] readFromFile(String fileName) {
        BufferedReader reader;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }
        if (stringBuilder.length() > 0) {
            String text = stringBuilder.toString();
            String textWithout = text.replaceAll("\\W+", " ");
            String[] allWords = textWithout.toLowerCase().split(" ");
            StringBuilder findWord = new StringBuilder();
            for (String word : allWords) {
                int index = word.indexOf(SEARCH_LETTER);
                if (index == 0) {
                    findWord.append(word).append(" ");
                }
            }
            if (findWord.length() == 0) {
                return new String[0];
            } else {
                String[] words = findWord.toString().split(" ");
                Arrays.sort(words);
                return words;
            }
        } else {
            return new String[0];
        }
    }
}
