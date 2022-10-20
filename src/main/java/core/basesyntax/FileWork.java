package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result = new String[fileName.length()];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int count = 0;
                for (String word : line.split("\\W+")) {
                    if (word.startsWith("w")) {
                        result[count] = word.toLowerCase();
                        count++;
                    }
                }
            }
        } catch (IOException a) {
            throw new RuntimeException("there is no such file");
        }
        Arrays.sort(result);
        return result;
    }
}
