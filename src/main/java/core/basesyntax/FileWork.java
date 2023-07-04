package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {

        List<String> sortWords = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] words = str.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        sortWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        sortWords.sort(String::compareToIgnoreCase);
        return sortWords.toArray(new String[0]);
    }
}

