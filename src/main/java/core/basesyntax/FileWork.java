package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {

    private final Pattern onlyLettersAndNumbers = Pattern.compile("[^a-zA-Z0-9]");

    public String[] readFromFile(String fileName) {
        try (Reader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                stringBuilder.append((char) bufferedReader.read());
            }
            System.out.println(stringBuilder);

            String[] array = Arrays.stream(stringBuilder.toString().split("\\s+"))
                    .map(s -> s.replaceAll(String.valueOf(onlyLettersAndNumbers), "").toLowerCase())
                    .filter(s -> !s.isEmpty() && s.charAt(0) == 'w')
                    .sorted()
                    .toArray(String[]::new);

            return array;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from file: " + fileName + e);
        }
    }
}
