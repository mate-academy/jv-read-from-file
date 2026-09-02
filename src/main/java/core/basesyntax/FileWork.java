package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String text = reader.lines().collect(Collectors.joining(" "));
            String[] words = text.split("[\\s\\p{Punct}]+");
            return Arrays.stream(words)
                    .filter(word -> word.startsWith("w") || word.startsWith("W"))
                    .map(word -> word.replaceAll("[\\p{Punct}]", "").toLowerCase())
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
