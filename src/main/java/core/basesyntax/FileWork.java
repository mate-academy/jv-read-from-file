package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int wordCntr = 0;
        try (BufferedReader countReader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = countReader.readLine()) != null) {
                String resultLine = line.replaceAll("[^a-zA-Z0-9]", " ");
                String[] words = resultLine.split(" ");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    word = word.toLowerCase();
                    if (word.startsWith("w")) {
                        wordCntr++;
                    }
                }
            }
        } catch (IOException e) {
            return new String[0];
        }
        if (wordCntr == 0) {
            return new String[0];
        }
        String[] wordsStartsW = new String[wordCntr];
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String resultLine = line.replaceAll("[^a-zA-Z0-9]", " ");
                String[] words = resultLine.split(" ");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    word = word.toLowerCase();
                    if (word.startsWith("w")) {
                        wordsStartsW[index] = word;
                        index++;
                    }
                }
            }
        } catch (IOException e) {
            return new String[0];
        }
        Arrays.sort(wordsStartsW);
        return wordsStartsW;
    }
}

