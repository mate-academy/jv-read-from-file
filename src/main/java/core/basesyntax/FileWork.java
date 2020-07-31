package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String KEY = "w";
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                line = line.toLowerCase();
                line = line.replaceAll("[^a-z]", " ");
                String[] separateWords = line.split("\\s+");
                for (String word : separateWords) {
                    if (word.startsWith(KEY)) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No such a file");
        }
        String[] newResult = result.toArray(new String[0]);
        Arrays.sort(newResult);
        return newResult;
    }
}
