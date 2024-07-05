package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    private static final String STARTS_WITH = "w";
    private static final String SPACE = " ";
    private static final String DELIMITERS_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder allText = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                allText.append(line).append(SPACE);
            }

            String[] infoFromFile = allText.toString().split(DELIMITERS_REGEX);
            String wordsStartingWith = getWordsStartingWithAndToLowerCase(infoFromFile);
            return (wordsStartingWith != null) ? getSortedArray(wordsStartingWith) : new String[0];
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private String getWordsStartingWithAndToLowerCase(String[] infoFromFile) {
        boolean isFound = false;
        StringBuilder wordsStartWithAndLowerCase = new StringBuilder();

        for (String word : infoFromFile) {
            if (word.toLowerCase().startsWith(STARTS_WITH)) {
                wordsStartWithAndLowerCase.append(word).append(SPACE);
                isFound = true;
            }
        }

        return (isFound) ? wordsStartWithAndLowerCase.toString().toLowerCase().trim() : null;
    }

    private String[] getSortedArray(String wordsStartingWith) {
        String[] wordsArray = wordsStartingWith.split(SPACE);
        Arrays.sort(wordsArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return wordsArray;
    }
}
