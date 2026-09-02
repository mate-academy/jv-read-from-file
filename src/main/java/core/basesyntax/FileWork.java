package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                for (String word : line.split("[!?,.() ]+")) {
                    word = word.toLowerCase();
                    if (word.charAt(0) == 'w') {
                        result.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file data", e);
        }
        if (result.isEmpty()) {
            return new String[0];
        }
        return Arrays.stream(result.toString().split(" ")).sorted().toArray(String[]::new);
    }
}
