package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try {
            String soursString = String.valueOf(Files.readAllLines(file.toPath())).toLowerCase();
            String[] split = soursString.split("\\W+");
            ArrayList<String> filtered = new ArrayList<String>();
            for (String word : split) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    filtered.add(word);
                }
            }
            String[] strings = filtered.toArray(String[]::new);
            Arrays.sort(strings);
            return strings;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
