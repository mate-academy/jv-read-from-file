package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPASE_WITH_PUNCTUATION = "\\W+";
    private static final String PREFIX = "w";
    private final StringBuilder readText = new StringBuilder();
    private final StringBuilder filterText = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                readText.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file with name" + fileName, e);
        }
        if (!readText.isEmpty()) {
            return filter(readText);
        }
        return new String[0];
    }

    private String[] filter(StringBuilder inputText) {
        String[] splitWords = inputText.toString().toLowerCase().split(SPASE_WITH_PUNCTUATION);
        for (String currentWord : splitWords) {
            if (currentWord.startsWith(PREFIX)) {
                filterText.append(currentWord).append(" ");
            }
        }
        if (filterText.isEmpty()) {
            return new String[0];
        }
        String[] result = filterText.toString().split(SPASE_WITH_PUNCTUATION);
        Arrays.sort(result);
        return result;
    }
}
