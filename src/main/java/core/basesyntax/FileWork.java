package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileWork {
    private static final String PATTERN_NEWLINE = "\n";
    private static final String PATTERN_LITTERS = "[^A-Za-z0-9 ]+";
    private static final String KEY = "w";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        File currentFile = new File(fileName);
        StringBuilder strBuildForRead = new StringBuilder();
        String matcherLitters = null;
        StringBuilder strBuildForSort = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(currentFile))) {
            int readValue = bufferedReader.read();
            if (readValue == -1) {
                return new String[0];
            }
            while (readValue != -1) {
                strBuildForRead.append((char) readValue);
                readValue = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file.", e);
        }

        final String lowerCase = strBuildForRead.toString().toLowerCase();

        try {
            matcherLitters = Pattern.compile(PATTERN_NEWLINE)
                    .matcher(lowerCase).replaceAll(SPACE);
            matcherLitters = Pattern.compile(PATTERN_LITTERS)
                    .matcher(matcherLitters).replaceAll("");
        } catch (PatternSyntaxException e) {
            System.out.printf("There is a problem with the regular expression!%n");
            System.out.printf("The pattern in question is: %s%n", e.getPattern());
            System.out.printf("The description is: %s%n", e.getDescription());
            System.out.printf("The message is: %s%n", e.getMessage());
            System.out.printf("The index is: %s%n", e.getIndex());
        }

        String[] words = (matcherLitters != null) ? matcherLitters.split(SPACE) : new String[0];

        for (String word : words) {
            if (word.startsWith(KEY)) {
                strBuildForSort.append(word).append(SPACE);
            }
        }
        if (!strBuildForSort.toString().contains(KEY)) {
            return new String[0];
        }
        String[] result = strBuildForSort.toString().split(SPACE);
        Arrays.sort(result);
        return result;
    }
}
