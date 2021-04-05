package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value.toLowerCase(Locale.ROOT)).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().replaceAll("\\W", " ").split(" ");
            stringBuilder.setLength(0);
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(word).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        }
        String[] filter = stringBuilder.toString().trim().split(" ");
        Arrays.sort(filter);
        return filter;

    }
}
