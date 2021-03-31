package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char FILTER_CHARACTER = 'w';
    public static final String SEPARATOR_CHARACTER = " ";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder text = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                for (String word : line.split(SEPARATOR_CHARACTER)) {
                    if (word.toLowerCase().charAt(0) == FILTER_CHARACTER) {
                        text.append(word.toLowerCase().replaceAll("[.,!?]", ""))
                                .append(System.lineSeparator());
                    }
                }
                line = reader.readLine();
            }
            if (text.length() > 1) {
                String[] result = text.toString().split(System.lineSeparator());
                Arrays.sort(result);
                return result;
            }
            return new String[0];
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }
}
