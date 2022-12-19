package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> resultList = new ArrayList<>();
        List<String> strings;
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        for (String result : strings) {
            String [] sorted = result.toLowerCase().split("\\W+");
            for (int i = 0; i < sorted.length; i++) {
                if (sorted[i].startsWith(SPECIFIED_CHARACTER)) {
                    resultList.add(sorted[i]);
                }
            }
            if (resultList.equals(null)) {
                return new String[]{};
            }
        }
        String[] words = resultList.toArray(new String[]{});
        Arrays.sort(words);
        return words;
    }
}
