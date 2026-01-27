package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] words = fileName.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            for (String word : words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(word.toLowerCase()).append(" ");
                }
            }
        } catch (IOException e) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().trim().split("\\s+");
        Arrays.sort(result);
        return result;
    }
}
