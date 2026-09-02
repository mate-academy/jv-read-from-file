package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> filterWords = new ArrayList<>();
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] words = value.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        filterWords.add(word);
                    }
                }
                value = bufferedReader.readLine();
            }
            String[] result = filterWords.toArray(new String[0]);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
