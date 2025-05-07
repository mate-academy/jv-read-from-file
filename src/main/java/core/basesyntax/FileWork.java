package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here
        String[] result;

        try {
            String readed = Files.readString(Paths.get(fileName));
            String[] words = readed.split("\\W+");
            result = filter(words);
        } catch (IOException e) {
            throw new RuntimeException("File reading error", e);
        }

        Arrays.sort(result);
        return result;
    }

    private String[] filter(String[] words) {
        ArrayList<String> result = new ArrayList<>();

        for (String s : words) {
            s = s.toLowerCase();
            if (s.length() > 1 && s.charAt(0) == SPECIFIED_CHARACTER) {
                result.add(s);
            }
        }

        return result.toArray(new String[0]);
    }
}
