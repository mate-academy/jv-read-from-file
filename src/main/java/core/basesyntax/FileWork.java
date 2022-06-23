package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX_LETTER_ONLY = "[^a-z]";
    private final StringBuilder stringOfWords = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File path = new File(fileName);

        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String value = file.readLine();

            while (value != null) {
                findWordsInLine(value);
                value = file.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }

        return createSortedArrFromString();
    }

    private void findWordsInLine(String line) {
        for (String word : line.split(" ")) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                String formattedWord = word.toLowerCase().replaceAll(REGEX_LETTER_ONLY, "");
                stringOfWords.append(formattedWord).append(" ");
            }
        }
    }

    private String[] createSortedArrFromString() {
        String[] foundWords;

        if (!stringOfWords.toString().isEmpty()) {
            foundWords = stringOfWords.toString().split(" ");
            Arrays.sort(foundWords);
        } else {
            foundWords = new String[0];
        }

        return foundWords;
    }
}
