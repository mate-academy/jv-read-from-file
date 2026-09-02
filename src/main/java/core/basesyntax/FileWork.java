package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WHITESPACE = " ";
    private static final String SPLIT_NON_WORD = "\\W+";
    private static final char FIRST_LATER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[] {};
            }
            while (value != null) {
                stringBuilder.append(value).append(WHITESPACE);
                value = reader.readLine();
            }
            StringBuilder keyWords = new StringBuilder();
            String[] stringFromFile = stringBuilder.toString().trim()
                    .toLowerCase().split(SPLIT_NON_WORD);
            for (int i = 0; i < stringFromFile.length; i++) {
                if (stringFromFile[i].charAt(0) == FIRST_LATER) {
                    keyWords.append(stringFromFile[i]).append(WHITESPACE);
                }
            }
            String checkEmpty = keyWords.toString();
            if (checkEmpty.isEmpty()) {
                return new String[] {};
            }
            String[] finalWords = checkEmpty.split(WHITESPACE);
            Arrays.sort(finalWords);
            return finalWords;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
