package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> fileData;
        try {
            fileData = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + e);
        }
        List<String> result = new ArrayList<>();
        for (String line : fileData) {
            String[] words = line.toLowerCase().split("\\W+");
            for (String word : words) {
                if (word.startsWith(CHARACTER)) {
                    result.add(word);
                }
            }
        }
        String[] resultString = result.toArray(new String[0]);
        Arrays.sort(resultString);
        return resultString;
    }
}
