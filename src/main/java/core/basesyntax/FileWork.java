package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SEPARATOR = " ";
    private static final String SPECIFIC_LETTER_LOWER_CASE = "w";
    private static final String SPECIFIC_LETTER_UPPER_CASE = "W";
    private String line = null;
    private List<String> result = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(SEPARATOR);
                for (String word : words) {
                    if (word.startsWith(SPECIFIC_LETTER_LOWER_CASE)
                            || word.startsWith(SPECIFIC_LETTER_UPPER_CASE)) {
                        StringBuilder cleanedWord = new StringBuilder();
                        for (char c : word.toCharArray()) {
                            if (Character.isLetter(c)) {
                                cleanedWord.append(c);
                            }
                        }
                        result.add(cleanedWord.toString().toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("There is some issue...", e);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
