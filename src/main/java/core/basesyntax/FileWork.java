package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Object[] data;
        try {
            if (Files.readAllBytes(new File(fileName).toPath()).length == 0) {
                return new String[] {};
            }
            data = Files.readAllLines(new File(fileName).toPath()).toArray();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
        int i = 0;
        int count = 0;
        for (Object line : data) {
            String[] words = line.toString().split("\\W+");
            for (String word : words) {
                if (word.toLowerCase().charAt(0) == 'w') {
                    count++;
                }
            }
        }
        String[] result = new String[count];
        for (Object line : data) {
            String[] words = line.toString().split("\\W+");
            for (String word : words) {
                if (word.toLowerCase().charAt(0) == 'w') {
                    result[i] = word.toLowerCase();
                    i++;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}
