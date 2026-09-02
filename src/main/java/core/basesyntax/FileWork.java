package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIC_WORD = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] arrayValue = value.toLowerCase().split("\\W");
                for (String words : arrayValue) {
                    if (words.startsWith(SPECIFIC_WORD)) {
                        stringBuilder.append(words.toLowerCase())
                                .append(" ");
                    }
                }
            }
            if (stringBuilder.length() == 0) {
                return new String[] {};
            }
            String[] finalWords = stringBuilder.toString().trim().split(" ");
            Arrays.sort(finalWords);
            return finalWords;
        } catch (IOException e) {
            throw new RuntimeException("Read from file", e);
        }
    }
}
