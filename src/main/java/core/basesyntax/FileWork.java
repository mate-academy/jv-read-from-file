package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private String[] words;

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            try {
                StringBuilder stringBuilder = new StringBuilder();
                int value = reader.read();
                if (value == -1) {
                    return new String[0];
                }
                while (value != -1) {
                    stringBuilder.append((char) value);
                    value = reader.read();
                }
                words = stringBuilder.toString().toLowerCase().split("\\W+");
            } catch (IOException e) {
                throw new RuntimeException("can't read to the file" + e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("can't find the file" + e);
        }
        return filterWords(words);
    }

    public String[] filterWords(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == 'w') {
                stringBuilder.append(word + System.lineSeparator());
            }
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] resultWords = stringBuilder.toString().split("\\W+");
        Arrays.sort(resultWords);
        return resultWords;
    }
}
