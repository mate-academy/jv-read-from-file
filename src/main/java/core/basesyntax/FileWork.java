package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.toLowerCase().split("[^a-zA-Z]+");
                for (String word : words) {
                    if (word.startsWith("w") && !word.isEmpty()) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file: " + fileName, e);
        }

        String[] array = result.toArray(new String[0]);
        Arrays.sort(array);
        return array;
    }
}
