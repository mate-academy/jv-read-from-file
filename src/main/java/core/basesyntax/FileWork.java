package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final char FIRST_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        ArrayList<String> list = new ArrayList<>();
        try {
            String[] strings = Files.readAllLines(file.toPath())
                    .toString().toLowerCase().split("\\W+");
            for (int i = 1; i < strings.length; i++) {
                if (strings[i].charAt(0) == FIRST_LETTER) {
                    list.add(strings[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] words = list.toArray(new String[list.size()]);
        Arrays.sort(words);
        return words;
    }
}
