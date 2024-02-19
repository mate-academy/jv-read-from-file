package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value);
                stringBuilder.append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException("Can't read file", ex);
        }

        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }

        String[] wordsFromFile = stringBuilder.toString().split("\\W+");
        return filterStrings(wordsFromFile);
    }

    private static String[] filterStrings(String[] unfilteredWords) {
        int count = 0;

        for (String word : unfilteredWords) {
            word = word.toLowerCase();
            if (word.charAt(0) == SPECIFIED_CHARACTER) {
                unfilteredWords[count] = word;
                count++;
            }
        }

        String[] filteredWords = new String[count];
        System.arraycopy(unfilteredWords, 0, filteredWords, 0, filteredWords.length);
        Arrays.sort(filteredWords);

        return filteredWords;
    }
}
