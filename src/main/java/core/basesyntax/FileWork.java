package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String sentence = reader.lines().collect(Collectors.joining(" "));
            String[] split = sentence.replaceAll("\\p{Punct}", "")
                    .toLowerCase()
                    .split("\\s+");
            String[] result = Arrays.stream(split)
                    .filter(word -> word.startsWith("w"))
                    .distinct()
                    .sorted()
                    .toArray(String[]::new);

            System.out.println(Arrays.asList(result));
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + e.getMessage(), e);
        }
    }
}
