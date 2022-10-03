package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }
        return getFilteredData(stringBuilder);
    }

    private String[] getFilteredData(StringBuilder stringBuilder) {
        String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
        return words;
    }
}
