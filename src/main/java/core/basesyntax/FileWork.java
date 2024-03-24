package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        String[] result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
            int count = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    count++;
                }
            }
            result = new String[count];
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith("w")) {
                    result[index++] = words[i];
                }
            }
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file", e);
        }
        return result;
    }
}
