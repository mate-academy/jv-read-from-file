package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String DELIMITER = " ";
    private static final String REGEX_FOR_CLEAN = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> input = null;
        try {
            input = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (input.size() == 0) {
            return new String[]{};
        }
        String[] words = splitData(input);
        Arrays.sort(words);
        return getWordsOnW(words);
    }

    private String[] splitData(List<String> input) {
        String inputString = input.stream().map(Object::toString)
                .collect(Collectors.joining(DELIMITER));
        return inputString.toLowerCase().split(REGEX_FOR_CLEAN);
    }

    private String[] getWordsOnW(String[] words) {
        int count = 0;

        for (String word : words) {
            if (word.charAt(0) == SPECIFIED_CHARACTER) {
                count++;
            }
        }
        String[] wordsOnW = new String[count--];

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].charAt(0) == SPECIFIED_CHARACTER) {
                wordsOnW[count--] = words[i];
            }
        }
        return wordsOnW;
    }
}
