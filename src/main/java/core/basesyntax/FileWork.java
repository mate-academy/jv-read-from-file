package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] wordsStartingWithW = new String[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            File file = new File(fileName);
            String value;
            if (fileName.isEmpty()) {
                return new String[0];
            }
            while ((value = reader.readLine()) != null) {
                String[] words = value.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    if (word.startsWith("w")) {
                        String[] newWordsStartingWithW = new String[wordsStartingWithW.length + 1];
                        for (int i = 0; i < wordsStartingWithW.length; i++) {
                            newWordsStartingWithW[i] = wordsStartingWithW[i];
                        }
                        newWordsStartingWithW[wordsStartingWithW.length] = word;
                        wordsStartingWithW = newWordsStartingWithW;
                    }
                }
            }
            Arrays.sort(wordsStartingWithW);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return wordsStartingWithW;
    }
}
