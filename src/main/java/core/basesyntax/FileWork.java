package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
            String[] results = builder.toString().split("[\\W]+");
            StringBuilder filteredWords = new StringBuilder();
            for (String result : results) {
                String lowerCase = result.toLowerCase();
                if (lowerCase.startsWith(SPECIFIED_LETTER)) {
                    filteredWords.append(lowerCase).append(" ");
                }
            }
            if (filteredWords.length() == 0) {
                return new String[0];
            }
            String[] finalResults = filteredWords.toString().split(" ");
            Arrays.sort(finalResults);
            return finalResults;
        } catch (IOException e) {
            throw new RuntimeException("Can not read a file", e);
        }
    }
}
