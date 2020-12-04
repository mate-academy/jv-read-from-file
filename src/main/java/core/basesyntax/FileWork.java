package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DETERMINER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String [] words = builder.toString().replaceAll("\\W", " ").split(" ");
            builder.setLength(0);
            for (String word : words) {
                if (word.startsWith(DETERMINER)) {
                    builder.append(word).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (builder.length() == 0) {
            return new String[]{};
        }
        String[] filterWords = builder.toString().trim().split(" ");
        Arrays.sort(filterWords);
        return filterWords;
    }
}
