package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public static final String W_START_REGEX = "[w][a-z]*";

    public String[] readFromFile(String fileName) {
        String sentence;
        try {
            sentence = Files.readString(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String [] substrings = sentence.toLowerCase().split("\\W+");
        String [] machedSubstrings = new String[substrings.length];
        int index = 0;
        for (String substring : substrings) {
            if (substring.matches(W_START_REGEX)) {
                machedSubstrings[index++] = substring;
            }
        }
        machedSubstrings = Arrays.copyOf(machedSubstrings, index);
        Arrays.sort(machedSubstrings);

        return machedSubstrings;
    }
}
