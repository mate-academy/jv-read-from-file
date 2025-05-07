package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        if (builder.toString().isEmpty()) {
            return new String[]{};
        }
        String[] splitWords = builder.toString().toLowerCase().split("\\W?(\\.\\.\\.)?'?\"? +");
        StringBuilder filteredWords = new StringBuilder();
        for (String word : splitWords) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                filteredWords.append(word).append(" ");
            }
        }
        if (filteredWords.toString().isEmpty()) {
            return new String[]{};
        }
        String[] filteredWordsArr = filteredWords.toString().split(" ");
        Arrays.sort(filteredWordsArr);
        return filteredWordsArr;
    }
}
