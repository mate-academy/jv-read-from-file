package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] result;
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
        result = new String[countValidWords(words)];

        int counter = 0;

        for (int i = 0; i < words.length; i++) {
            if (startWithLetter(words[i])) {
                result[counter] = words[i];
                counter++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private int countValidWords(String[] words) {
        int counterValidWords = 0;
        for (String word : words) {
            if (startWithLetter(word)) {
                counterValidWords++;
            }
        }
        return counterValidWords;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}

