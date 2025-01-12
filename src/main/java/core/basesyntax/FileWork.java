package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path filePath = Path.of(fileName);
        try {
            String content = new String(Files.readAllBytes(filePath));
            System.out.println(content);
            for (String word : getWordsStartingWithW(content)) {
                System.out.println(word);
            }
            return getWordsStartingWithW(content);
        } catch (IOException e) {
            throw new RuntimeException("File not found" + e);
        }
    }

    public static String[] getWordsStartingWithW(String content) {
        Pattern pattern = Pattern.compile("\\b[wW]\\w*");
        Matcher matcher = pattern.matcher(content);

        int matchCount = 0;
        while (matcher.find()) {
            matchCount++;
        }

        String[] matchingWords = new String[matchCount];
        matcher.reset();
        int index = 0;
        while (matcher.find()) {
            matchingWords[index++] = matcher.group().toLowerCase();
        }
        Arrays.sort(matchingWords);
        return matchingWords;
    }
}
