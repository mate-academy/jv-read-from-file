package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String STARTING_LETTER = "w";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line).append(LINE_SEPARATOR);
            }
            String[] words = fileContent.toString().toLowerCase().split("\\W+");
            List<String> filteredWords = new ArrayList<>();
            for (String word : words) {
                if (word.startsWith(STARTING_LETTER)) {
                    filteredWords.add(word);
                }
            }
            String[] result = filteredWords.toArray(new String[0]);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("can`t reach file: " + fileName, e);
        }
    }
}
