package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }
        String sentence = builder.toString().toLowerCase();
        String[] words = sentence.split("\\W+");
        int length = 0;
        for (String word : words) {
            if (word.length() > 0 && word.charAt(0) == 'w') {
                length++;
            }
        }
        if (length == 0) {
            return new String[]{};
        }
        String[] result = new String[length];
        int index = 0;
        for (String word : words) {
            if (word.length() > 0 && word.charAt(0) == 'w') {
                result[index++] = word;
            }
        }
        Arrays.sort(result);
        return result;
    }
}

