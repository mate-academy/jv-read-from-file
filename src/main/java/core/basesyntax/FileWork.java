package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGULAR_EXPRESSION = "\\W+";
    private static final String DELIMITER = " ";

    public String[] readFromFile(String fileName) {
        final StringBuilder stringBuilder = new StringBuilder();
        boolean wordFound = false;

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String fileLine;

            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] data = fileLine.split(REGULAR_EXPRESSION);
                for (String word : data) {
                    word = word.toLowerCase();
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word);
                        stringBuilder.append(DELIMITER);
                        wordFound = true;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] result = stringBuilder.toString().split(DELIMITER);
        Arrays.sort(result);

        return (wordFound) ? result : new String[0];
    }
}
