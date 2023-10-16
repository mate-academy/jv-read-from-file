package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String SEPARATOR = " ";
    private static final char firstCharacter = 'w';
    private String newLine;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((newLine = bufferedReader.readLine()) != null) {
                String[] lineWords = newLine
                        .toLowerCase()
                        .split("\\W+");
                for (String word : lineWords) {
                    if (word.charAt(0) == firstCharacter) {
                        stringBuilder
                                .append(word.toLowerCase())
                                .append(SEPARATOR);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file:" + fileName, e);
        }
        String[] endLine = stringBuilder.toString().split(SEPARATOR);
        Arrays.sort(endLine);
        if (endLine[0].isEmpty()) {
            return new String[]{};
        } else {
            return endLine;
        }
    }
}
