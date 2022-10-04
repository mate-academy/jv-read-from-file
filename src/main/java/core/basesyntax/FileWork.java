package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return filterFile(stringBuilder);
    }

    private String[] filterFile(StringBuilder stringBuilder) {
        String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
        int arrayLength = 0;
        for (String word : words) {
            if (word.startsWith(FIRST_LETTER)) {
                arrayLength++;
            }
        }
        String[] wordsStartingWithW = new String[arrayLength];
        int index = 0;
        for (String word : words) {
            if (word.startsWith("w")) {
                wordsStartingWithW[index] = word;
                index++;
            }
        }
        Arrays.sort(wordsStartingWithW);
        return wordsStartingWithW;
    }
}
