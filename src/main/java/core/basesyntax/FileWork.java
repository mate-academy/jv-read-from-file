package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX_PATTERN = "\\W+";

    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(REGEX_PATTERN);

                for (String word : words) {
                    String wordInLowerCase = word.toLowerCase();
                    if (wordInLowerCase.startsWith(SPECIFIED_CHARACTER)) {
                        wordsStartingWithW.add(wordInLowerCase);
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("File not found");
        }

        Collections.sort(wordsStartingWithW);
        return wordsStartingWithW.toArray((String[]::new));
    }
}
