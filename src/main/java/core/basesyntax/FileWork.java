package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();

            while (value != null) {
                for (String word : value.toLowerCase().split("\\W+")) {
                    if (startWithLetter(word)) {
                        stringBuilder.append(word).append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[] {};
        }
        String[] readingResult = stringBuilder.toString().split(" ");
        Arrays.sort(readingResult);
        return readingResult;
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
