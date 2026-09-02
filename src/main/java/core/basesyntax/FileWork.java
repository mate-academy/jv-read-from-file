package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            content = content.toLowerCase();
            content = content.replaceAll("[^a-z ]", " ");
            String[] words = content.split("\\s+");
            int count = 0;
            for (String word: words) {
                if (word.startsWith("w")) {
                    count++;
                }
            }

            if (count == 0) {
                return new String[0];
            }
            String[] filteredWords = new String[count];
            int index = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    filteredWords[index++] = word;
                }
            }

            for (int i = 0; i < filteredWords.length - 1; i++) {
                for (int j = i + 1; j < filteredWords.length; j++) {
                    if (filteredWords[i].compareTo(filteredWords[j]) > 0) {
                        String temp = filteredWords[i];
                        filteredWords[i] = filteredWords[j];
                        filteredWords[j] = temp;
                    }
                }
            }

            return filteredWords;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file", e);
        }
    }
}
