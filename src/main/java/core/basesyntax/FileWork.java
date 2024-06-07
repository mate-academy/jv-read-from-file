package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        char filterChar = 'w';
        String[] filteredWords = filterWordsByFirstChar(fileName, filterChar);
        return filteredWords;
    }

    public static String[] filterWordsByFirstChar(String fileName, char filterChar) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\P{IsAlphabetic}+");
                for (String word : words) {
                    if (!word.isEmpty() && word.charAt(0) == filterChar) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(result);

        return result.toArray(new String[0]);
    }
}
