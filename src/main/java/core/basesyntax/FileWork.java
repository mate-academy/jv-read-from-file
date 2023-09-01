package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARACTER = "\\W+";
    private static final String RIGHT_LETTER = "w";
    private static final String SPACE = " ";

    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] rightWordsArray;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line + SPACE);
                line = bufferedReader.readLine();
            }
            String[] splitWords = stringBuilder.toString().toLowerCase().split(CHARACTER);
            stringBuilder.delete(0, stringBuilder.length());
            for (int i = 0; i < splitWords.length; i++) {
                if (splitWords[i].startsWith(RIGHT_LETTER)) {
                    stringBuilder.append(splitWords[i] + SPACE);
                }
            }
            if (stringBuilder.length() == 0) {
                return new String[0];
            }
            rightWordsArray = stringBuilder.toString().split(SPACE);
            Arrays.sort(rightWordsArray);
            return rightWordsArray;
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
    }
}
