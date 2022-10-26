package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            stringBuilder.append(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        for (String word : stringBuilder.toString().toLowerCase().split("\\W+")) {
            if (word.charAt(0) == SPECIFIED_CHARACTER) {
                result.add(word);
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
