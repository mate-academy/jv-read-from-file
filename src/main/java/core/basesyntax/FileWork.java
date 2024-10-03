package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String START_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] fileToArray = line.split("\\W+");
                for (String words : fileToArray) {
                    if (words.toLowerCase().startsWith(START_CHARACTER)) {
                        builder.append(words).append(" ");
                    }
                }
            }
            if (builder.length() == 0) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file ", e);
        }
        String[] result = builder.toString().toLowerCase().trim().split(" ");
        Arrays.sort(result);
        return result;
    }
}
