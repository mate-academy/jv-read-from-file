package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    String lowerCaseWord = word.toLowerCase();
                    if (lowerCaseWord.startsWith(CHARACTER)) {
                        result.add(lowerCaseWord);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
        result.sort(String.CASE_INSENSITIVE_ORDER);
        return result.toArray(new String[0]);
    }
}
