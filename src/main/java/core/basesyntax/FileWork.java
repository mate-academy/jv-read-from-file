package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here

        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String content = reader.lines().collect(Collectors.joining(" "));

            return Arrays.stream(content.toLowerCase()
                                        .replaceAll("[^a-zA-Z ]", "")
                                        .split("\\s+"))
                                        .filter(word -> word.startsWith("w"))
                                        .sorted()
                                        .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
