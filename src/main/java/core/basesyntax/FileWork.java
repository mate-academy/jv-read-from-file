package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String REGEX = "[^A-Za-z0-9 ]+";
    private static final String WORD_DELIMITER = "\\s+";
    private static final String REQUIRED_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String fileContent;
        try {
            fileContent = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(fileContent);
        String stringWithoutPunctuation = matcher.replaceAll(" ");
        String[] arrayOfWords = stringWithoutPunctuation.split(WORD_DELIMITER);

        int count = 0;
        for (String word : arrayOfWords) {
            if (word.toLowerCase().startsWith(REQUIRED_LETTER)) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (String word : arrayOfWords) {
            if (word.toLowerCase().startsWith(REQUIRED_LETTER)) {
                result[index] = word.toLowerCase();
                index++;
            }
        }

        Arrays.sort(result);
        return result;
    }
}

