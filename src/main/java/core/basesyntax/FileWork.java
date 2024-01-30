package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private final List<String> totalResult = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] separatedWords = line.split("[^a-zA-Z]");
                for (String word : separatedWords) {
                    if (!word.isEmpty()) {
                        totalResult.add(word.toLowerCase());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        totalResult.sort(String::compareToIgnoreCase);
        return totalResult.toArray(new String[0]);
    }
}
