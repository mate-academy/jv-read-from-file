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
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s\\p{Punct}]+");
                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {
                        filteredWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result, String.CASE_INSENSITIVE_ORDER);
        return result;
    }
}
