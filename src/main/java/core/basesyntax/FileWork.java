package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARACTER_FOR_FILTER = "w";
    private StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String lineContent = reader.readLine();
            while (lineContent != null) {
                stringBuilder.append(System.lineSeparator())
                        .append(lineContent);
                lineContent = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file", e);
        }

        String[] words = stringBuilder
                .toString()
                .toLowerCase()
                .split("\\W+");
        stringBuilder = new StringBuilder();
        for (String word: words) {
            if (word.startsWith(CHARACTER_FOR_FILTER)) {
                stringBuilder.append(word).append(System.lineSeparator());
            }
        }
        String[] result = stringBuilder.isEmpty()
                ? new String[]{}
                : stringBuilder.toString().split(System.lineSeparator());
        Arrays.sort(result);

        return result;
    }
}
