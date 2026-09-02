package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char LETTER = 'w';

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try {
            File file = new File(fileName);
            String[] strings = Files.readAllLines(file.toPath()).toString().split("\\W+");
            for (int i = 1; i < strings.length; i++) {
                if (strings[i].toLowerCase().charAt(0) == LETTER) {
                    result.add(strings[i].toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] strings = result.toArray(new String[result.size()]);
        Arrays.sort(strings);
        return strings;
    }
}
