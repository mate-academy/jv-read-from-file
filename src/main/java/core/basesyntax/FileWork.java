package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final char CHAR_WITH_WHICH_WORDS_MUST_STARTED = 'w';

    public String[] readFromFile(String fileName) {
        String[] splittingText = getReadingStringInLowerCase(fileName).split(REGEX);
        StringBuilder builder = new StringBuilder();
        for (String s : splittingText) {
            if (s.length() > 0 && s.charAt(0) == CHAR_WITH_WHICH_WORDS_MUST_STARTED) {
                builder.append(s).append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[0];
        } else {
            String[] arrayWordsWhichStartedW = builder.toString().split(" ");
            Arrays.sort(arrayWordsWhichStartedW);
            return arrayWordsWhichStartedW;
        }
    }

    private String getReadingStringInLowerCase(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        List <String> strings;
        try {
        strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
            return builder.append(strings).toString().toLowerCase();
    }
}
