package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) throws IOException {
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String clearLine = line.toLowerCase().replaceAll("[^a-z\\s]", "");
                String[] words = clearLine.split("\\s+");

                for (String word : words) {
                    if (word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        result.sort(String::compareTo);

        return result.toArray(new String[0]);
    }
}
