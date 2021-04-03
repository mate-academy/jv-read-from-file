package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        String textFromFiles = new String();
        try {
            textFromFiles = Files.readAllLines(myFile.toPath()).toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return filterWordsWithW(textFromFiles);
    }

    public static String[] filterWordsWithW(String toFilter) {
        toFilter = filterLetters(toFilter);
        Pattern pattern = Pattern.compile("(?i)\\bw\\w*\\b");
        int count = 0;

        Matcher matcher = pattern.matcher(toFilter);
        while (matcher.find()) {
            count++;
        }

        String[] matchingWords = new String[count];

        int i = 0;
        matcher = pattern.matcher(toFilter);
        while (matcher.find()) {
            matchingWords[i] = matcher.group().replaceAll(" ", "").toLowerCase();
            i++;
        }

        Arrays.sort(matchingWords);

        return matchingWords;
    }

    public static String filterLetters(String toFilter) {

        System.out.println(toFilter.replaceAll("[^a-zA-Z0-9 ]",""));
        return toFilter.replaceAll("[^a-zA-Z0-9 ]","");
    }
}
