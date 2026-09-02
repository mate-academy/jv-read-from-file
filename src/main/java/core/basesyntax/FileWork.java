package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value;
            while ((value = reader.readLine()) != null) {
                String[] line = value.toLowerCase().split("\\W+");
                for (String word : line) {
                    if (word.matches("w\\p{Alpha}*")) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        words.sort(null);
        return words.toArray(new String[0]);
    }
}
