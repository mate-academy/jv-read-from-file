package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (builder.isEmpty()) {
            return new String[0];
        }
        String[] words = builder.toString().toLowerCase().split("\\W+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("w")) {
                result.append(word).append(",");
            }
        }
        if (result.isEmpty()) {
            return new String[0];
        }
        String[] resultFile = result.toString().trim().split(",");
        Arrays.sort(resultFile);
        return resultFile;
    }
}
