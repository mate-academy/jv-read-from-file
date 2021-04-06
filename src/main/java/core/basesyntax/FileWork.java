package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder returnBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word: words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        returnBuilder.append(word).append(" ");
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Unable to read the file", e);
        }
        if (returnBuilder.length() == 0) {
            return new String[]{};
        }
        String[] wordsStartingWithW = returnBuilder.toString().split(" ");
        Arrays.sort(wordsStartingWithW);
        return wordsStartingWithW;
    }
}
