package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] result;
        if (fileName.isEmpty()) {
            return new String[0];
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(" ");
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder
                    .toString()
                    .replaceAll("[.!,?\\-]", " ")
                    .split(" ");

            result = Arrays.stream(words)
                    .filter(this::startsWithLetter)
                    .sorted()
                    .toArray(String[]::new);

        } catch (IOException e) {
            throw new RuntimeException("Couldn`t read file " + fileName, e);
        }
        return result;
    }

    public boolean startsWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
