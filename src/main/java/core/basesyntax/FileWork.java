package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String WORDS_SEPARATOR = " ";
    private static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder builder = new StringBuilder();
        String[] wordsWithTargetStartLetter;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            int countAppropriateWords = 0;
            while (value != null) {
                value = value.replaceAll("\\p{Punct}", "").toLowerCase();
                String[] words = value.split(WORDS_SEPARATOR);
                for (String word : words) {
                    if (word.startsWith(START_LETTER)) {
                        builder.append(word).append(WORDS_SEPARATOR);
                        countAppropriateWords++;
                    }
                }
                value = bufferedReader.readLine();
            }
            if (countAppropriateWords == 0) {
                return new String[0];
            }
            wordsWithTargetStartLetter = builder.toString().trim().split(WORDS_SEPARATOR);
            Arrays.sort(wordsWithTargetStartLetter);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file", e);
        }
        return wordsWithTargetStartLetter;
    }
}
