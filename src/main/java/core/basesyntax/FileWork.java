package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] words = line.toLowerCase().split("[^a-z]+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        String[] resultArray = result.toArray(new String[0]);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
