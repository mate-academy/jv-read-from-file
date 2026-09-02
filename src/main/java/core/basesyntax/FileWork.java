package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_MODIFIER = "\\W";
    private static final String START_CHARACTER = "w";
    private static final String WORD_SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder fileStringBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                fileStringBuilder.append(line).append(WORD_SEPARATOR);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] fullFileArray = fileStringBuilder.toString().toLowerCase().split(REGEX_MODIFIER);
        StringBuilder resultWords = new StringBuilder();
        for (String word : fullFileArray) {
            if (word.startsWith(START_CHARACTER)) {
                resultWords.append(word).append(WORD_SEPARATOR);
            }
        }
        if (resultWords.length() == 0) {
            return new String[]{};
        }
        String[] resultArray = resultWords.toString().split(WORD_SEPARATOR);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
