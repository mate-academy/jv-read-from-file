package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W";
    private static final int START_INDEX = 0;
    private static final char W = 'w';
    private static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = filterFile(stringBuilder);
        Arrays.sort(result);
        return result;
    }

    private String[] filterFile(StringBuilder builder) {
        String[] wordsFromFile = builder.toString()
                .split(REGEX);
        builder = new StringBuilder();
        for (String word : wordsFromFile) {
            word = word.replaceAll(WHITESPACE, "")
                    .toLowerCase();
            if (word.length() > 0 && word.charAt(START_INDEX) == W) {
                builder.append(word)
                        .append(WHITESPACE);
            }
        }
        return builder.length() != 0
                ? builder.toString().split(WHITESPACE) : new String[]{};
    }
}
