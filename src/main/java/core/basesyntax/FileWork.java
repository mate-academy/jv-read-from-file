package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int value;
            do {
                value = br.read();
                sb.append((char) value);
            } while (value != -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] wordsArr = sb.toString().split("\\W+");
        return Arrays.stream(wordsArr)
                .map(String::toLowerCase)
                .filter(w -> w.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
