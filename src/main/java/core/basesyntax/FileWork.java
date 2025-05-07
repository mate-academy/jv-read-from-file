package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result;
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (word.toLowerCase().startsWith("w")) {
                        builder.append(word).append(" ");
                    }
                }
            }
            result = builder.toString().split(" ");
            Arrays.sort(result);
            if (result[0].isEmpty()) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        return result;
    }
}
