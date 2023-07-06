package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.toLowerCase().charAt(0) == 'w') {
                        wordsList.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(wordsList);
        return wordsList.toArray(new String[0]);
    }
}
