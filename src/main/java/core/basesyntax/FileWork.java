package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIC_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        List<String> wordsStartingWithW = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!cleanedWord.isEmpty() && cleanedWord.startsWith(SPECIFIC_CHARACTER)) {
                        wordsStartingWithW.add(cleanedWord);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file",e);
        }
        String[] result = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
