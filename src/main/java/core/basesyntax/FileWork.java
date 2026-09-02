package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] wordsStartingWithW = new String[0];
        int numWordsStartingWithW = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split("[\\p{Punct}\\s]+");
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        if (numWordsStartingWithW == wordsStartingWithW.length) {
                            wordsStartingWithW = Arrays.copyOf(wordsStartingWithW,
                                    numWordsStartingWithW + 1);
                        }
                        wordsStartingWithW[numWordsStartingWithW] = word;
                        numWordsStartingWithW++;
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
        Arrays.sort(wordsStartingWithW, 0, numWordsStartingWithW);
        return Arrays.copyOf(wordsStartingWithW, numWordsStartingWithW);
    }
}

