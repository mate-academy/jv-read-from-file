package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitWords = line.split("\\W+");
                for (String word : splitWords) {
                    if (word.toLowerCase().startsWith("w")) {
                        words.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read a file", e);
        }
        String[] result = words.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
