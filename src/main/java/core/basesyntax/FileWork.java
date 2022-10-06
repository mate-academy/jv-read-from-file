package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[] {};
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            char[] wordToChar = word.toCharArray();
            if (wordToChar[0] == 'w') {
                builder.append(word).append(" ");
            }
        }
        if (builder.toString().equals("")) {
            return new String[] {};
        }
        String[] result = builder.toString().split(" ");
        for (int i = 0; i < result.length - 1; i++) {
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
