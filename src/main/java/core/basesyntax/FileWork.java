package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {

    private static final String SPLIT_REGEX = "[\\p{Punct}\\s]+";

    public String[] readFromFile(String fileName) {
        String text;

        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] words = text.toLowerCase().split(SPLIT_REGEX);

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty() && words[i].charAt(0) == 'w') {
                count++;
            }
        }

        if (count == 0) {
            return new String[0];
        }

        String[] newWords = new String[count];
        int newCount = 0;

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty() && words[i].charAt(0) == 'w') {
                newWords[newCount] = words[i].toLowerCase();
                newCount++;
            }
        }

        Arrays.sort(newWords);

        return newWords;
    }
}
