package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                String[] splited = line.split("\\W+");
                for (String word: splited) {
                    if (word.toLowerCase().charAt(0) == 'w') {
                        text.append(word.toLowerCase()).append(" ");
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not found", e);
        }

        if (text.isEmpty()) {
            return new String[0];
        }

        String[] words = text.toString().split(" ");
        Arrays.sort(words);
        return words;
    }
}
