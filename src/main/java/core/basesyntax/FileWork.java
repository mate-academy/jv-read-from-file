package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static char TARGET_SYMBOL = 'w';

    public String[] readFromFile(String fileName) {
        String text = readFileByName(fileName);
        String[] allWords = findAllWords(text);
        Arrays.sort(allWords);
        return allWords;
    }

    private String readFileByName(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t reed file by name - " + fileName
                    + System.lineSeparator() + e);
        }
    }

    private String[] findAllWords(String text) {
        Pattern pattern = Pattern.compile("\\b" + TARGET_SYMBOL + "[a-z]+\\b");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        List<String> allWords = new ArrayList<>();
        while (matcher.find()) {
            allWords.add(matcher.group());
        }
        return allWords.toArray(String[]::new);
    }
}
