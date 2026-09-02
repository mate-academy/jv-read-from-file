package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char FOUND_CHAR = 'w';
    private final StringBuilder saveWordsFromFile = new StringBuilder();
    private final StringBuilder foundWordsStringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader readCreatedFile = new BufferedReader(new FileReader(fileName));
            int charValues = readCreatedFile.read();

            if (charValues == -1) {
                return new String[0];
            }

            while (charValues != -1) {
                saveWordsFromFile.append((char) charValues);
                charValues = readCreatedFile.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return getSplitString(saveWordsFromFile);
    }

    private String[] getSplitString(StringBuilder string) {
        String[] allWordsArray = string.toString().toLowerCase().split("\\W+");

        for (String split : allWordsArray) {
            if (split.charAt(0) == FOUND_CHAR) {
                foundWordsStringBuilder.append(split).append(" ");
            }
        }

        if (foundWordsStringBuilder.isEmpty()) {
            return new String[0];
        }

        String [] foundWordsArray = foundWordsStringBuilder.toString().split(" ");
        Arrays.sort(foundWordsArray);

        return foundWordsArray;
    }

}
