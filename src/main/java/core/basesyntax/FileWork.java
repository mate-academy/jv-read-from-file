package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX = "\\W";
    private static final String SPACE_DIVIDER = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line.toLowerCase(Locale.ROOT)).append(System.lineSeparator());
            }
            String[] words = stringBuilder.toString().replaceAll(REGEX, SPACE_DIVIDER)
                    .split(SPACE_DIVIDER);
            stringBuilder.setLength(0);
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(word).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        }
        String[] validWords = stringBuilder.toString().trim().split(" ");
        Arrays.sort(validWords);
        return validWords;

    }
}
