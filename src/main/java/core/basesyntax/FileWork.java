package core.basesyntax;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char wordWithW = 'w';

    public String[] readFromFile(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("Resource not found: fileName");
        }
        List<String> wordsResult = new ArrayList<>();

        try (BufferedReader readerFile = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = readerFile.readLine()) != null) {
                String[] words = line.toLowerCase().split("[^a-z]+");

                for (String word : words) {
                    if (!word.isEmpty() && word.charAt(0) == wordWithW) {
                        wordsResult.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] listArrayResult = wordsResult.toArray(new String[0]);
        Arrays.sort(listArrayResult);
        return listArrayResult;
    }
}
