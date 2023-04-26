package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPACE_SEPARATOR = " ";
    private static final String REGEX_SEPARATOR = "[\\p{Punct}\\s]+";
    private static final String INITIAL_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                addSuitableWordsToBuilder(line, stringBuilder);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
        String resultAsString = stringBuilder.toString();
        if (resultAsString.isEmpty()) {
            return new String[]{};
        }
        String[] words = resultAsString.split(SPACE_SEPARATOR);
        Arrays.sort(words);
        return words;
    }

    private void addSuitableWordsToBuilder(String string, StringBuilder stringBuilder) {
        String[] words = string.toLowerCase().split(REGEX_SEPARATOR);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.startsWith(INITIAL_LETTER)) {
                stringBuilder.append(word).append(SPACE_SEPARATOR);
            }
        }
    }
}
