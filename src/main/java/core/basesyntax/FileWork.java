package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private final List<String> totalResult = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] separatedWords = line.split("\\s+");

                for (String word : separatedWords) {

                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    if (word.startsWith("w")) {
                        totalResult.add(word);
                    }
                }
            }
            Collections.sort(totalResult);
            return totalResult.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("File is don`t open: " + fileName, e);
        }
    }
}
