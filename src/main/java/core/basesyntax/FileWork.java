package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] words = readFile(fileName).toLowerCase().split("\\W+");
        int size = getFilteredArraySize(words);
        String[] filteredWords = new String[size];
        fillFilteredArray(words, filteredWords);
        Arrays.sort(filteredWords);
        return filteredWords;
    }

    private String readFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    private int getFilteredArraySize(String[] words) {
        int counter = 0;
        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                counter++;
            }
        }
        return counter;
    }

    private void fillFilteredArray(String[] words, String[] filteredWords) {
        int index = 0;
        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                filteredWords[index] = word;
                index++;
            }
        }
    }
}
