package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while (value != -1) {
                if (value != '!' && value != '?' && value != '.' && value != ',') {
                    if (value == '\n' || value == '\r') {
                        value = ' ';
                        builder.append((char) value);
                    } else {
                        builder.append((char) value);
                    }
                }
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }

        String[] allWords = builder.toString().toLowerCase().split(" ");
        StringBuilder wordsStartWithW = new StringBuilder();

        for (String word : allWords) {
            if (word.startsWith("w")) {
                wordsStartWithW.append(word);
                wordsStartWithW.append(" ");
            }
        }

        if (wordsStartWithW.isEmpty()) {
            return new String[0];
        }

        String[] words = wordsStartWithW.toString().split(" ");
        Arrays.sort(words);
        System.out.println(words[0]);

        return words;
    }
}
