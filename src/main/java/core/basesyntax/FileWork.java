package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^a-zA-Z]+");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    String loweredCaseWord = word.toLowerCase();
                    if (loweredCaseWord.startsWith("w")) {
                        result.add(loweredCaseWord);
                    }
                }
            }
        } catch (IOException e) {
            return new String[0];
        }
        Collections.sort(result);
        return result.toArray(new String[0]);

    }
}
