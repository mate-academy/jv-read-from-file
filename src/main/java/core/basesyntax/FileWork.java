package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String text;
        String[] words = null;
        try {
            text = Files.readString(Paths.get(fileName)).toLowerCase();
            words = text.split("\\W+");
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }

        if (words.length == 1 && words[0].isEmpty()) {
            return new String[0];
        }

        int arraySize = 0;

        for (String word : words) {
            if (word.charAt(0) == 'w') {
                arraySize++;
            }
        }

        String[] result = new String[arraySize];

        int index = 0;
        for (String word : words) {
            if (word.charAt(0) == 'w') {
                result[index++] = word;
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].compareTo(result[j]) > 0) {
                    String temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        return result;
    }
}
