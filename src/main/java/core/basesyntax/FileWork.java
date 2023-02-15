package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_FOR_SPLITTING_NON_WORDS = "\\W+";
    private static final String REGEX_SPACE = " ";
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder textInFile = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                textInFile.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] wordsWithoutPunctuation = textInFile.toString()
                .split(REGEX_FOR_SPLITTING_NON_WORDS);
        StringBuilder wordsStartingWithW = new StringBuilder();

        for (String word: wordsWithoutPunctuation) {
            word = word.toLowerCase();
            if (word.charAt(0) == SPECIFIED_CHARACTER) {
                wordsStartingWithW.append(word).append(REGEX_SPACE);
            }
        }

        if (wordsStartingWithW.length() == 0) {
            return new String[]{};
        }

        String[] sortedArrayOfWWords = wordsStartingWithW.toString().split(REGEX_SPACE);
        Arrays.sort(sortedArrayOfWWords);
        return sortedArrayOfWWords;
    }
}
