package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] splitWords;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            StringBuilder content = new StringBuilder();
            while (value != -1) {
                content.append((char) value);
                value = reader.read();
            }
            splitWords = content.toString().toLowerCase().split(" ");
        } catch (IOException e) {
            throw new RuntimeException("Input not correct", e);
        }
        StringBuilder wWords = new StringBuilder();
        String[] result = null;
        for (String word : splitWords) {
            if (word.startsWith("w")) {
                char[] letters = word.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    if (!Character.isLetter(letters[i])) {
                        letters[i] = ' ';
                    }
                }
                word = new String(letters).trim();
                wWords.append(word).append(" ");
            }
            if (!wWords.isEmpty()) {
            result = wWords.toString().split(" ");
            } else {
                result = new String[0];
            }
        }
        if(result != null) {
            Arrays.sort(result);
        }
        return result;
    }
}
