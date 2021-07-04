package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String ONLY_START_WITH_W = ("(?i)\\bw\\w*");
    private static final String ONLY_LETTERS = ("[^a-zA-Z0-9 ]");

    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        String textFromFiles;
        try {
            textFromFiles = Files.readAllLines(myFile.toPath()).toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return filterWordsWithW(textFromFiles);
    }

    private String[] filterWordsWithW(String toFilter) {
        toFilter = filterLetters(toFilter);
        Pattern pattern = Pattern.compile(ONLY_START_WITH_W);
        int count = 0;
        Matcher matcher = pattern.matcher(toFilter);
        while (matcher.find()) {
            count++;
        }
        String[] matchingWords = new String[count];
        int i = 0;
        matcher = pattern.matcher(toFilter);
        while (matcher.find()) {
            matchingWords[i] = matcher.group().trim().toLowerCase();
            i++;
        }
        Arrays.sort(matchingWords);
        return matchingWords;
    }

    private String filterLetters(String toFilter) {
        return toFilter.replaceAll(ONLY_LETTERS, "");
    }
}
