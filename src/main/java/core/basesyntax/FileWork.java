package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String UNUSED_CHARACTERS = "[.,?!]";
    private static final String SPACE_DIVIDER = " ";
    private static final String REGEX_FOR_SPLIT = "\\s+";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        String[] arrayOfAllWords = stringBuilder.toString().toLowerCase()
                .replaceAll(UNUSED_CHARACTERS, "").trim().split(REGEX_FOR_SPLIT);
        Arrays.sort(arrayOfAllWords);
        stringBuilder = new StringBuilder();
        for (String singleWord : arrayOfAllWords) {
            if (singleWord.charAt(0) == SPECIFIED_CHARACTER) {
                stringBuilder.append(singleWord).append(SPACE_DIVIDER);
            }
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        return stringBuilder.toString().split(" ");
    }
}
