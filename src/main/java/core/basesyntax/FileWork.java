package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String fileContent;
        try {
            fileContent = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Pattern pattern = Pattern.compile("\\b" + SPECIFIED_CHARACTER + "\\w*");
        Matcher matcher = pattern.matcher(fileContent.toLowerCase());
        int wordsCount = 0;
        while (matcher.find()) {
            wordsCount++;
        }
        String[] words = new String[wordsCount];
        int i = 0;
        matcher.reset();
        while (matcher.find()) {
            words[i] = matcher.group();
            i++;
        }
        Arrays.sort(words);
        return words;
    }
}
