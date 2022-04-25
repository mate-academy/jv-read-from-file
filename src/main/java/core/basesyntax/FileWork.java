package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringValue = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringValue.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("This file doesnt exist", e);
        }
        String wordDataBase = stringValue.toString();
        String[] words = wordDataBase.split("\\W+");
        for (String word : words) {
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                result.append(word.toLowerCase()).append(" ");
            }
        }
        if (result.toString().isEmpty()) {
            return new String[]{};
        } else {
            words = result.toString().split(" ");
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].compareTo(words[j]) > 0) {
                        String temp = words[i];
                        words[i] = words[j];
                        words[j] = temp;
                    }
                }
            }
            return words;
        }
    }
}
