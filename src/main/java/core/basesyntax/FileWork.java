package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("can't read file" + e);
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        String[] words = stringBuilder.toString().split("\\W+");
        StringBuilder builderWithW = new StringBuilder();
        int wWords = 0;
        for (String word: words) {
            if (word.toLowerCase().startsWith("w")) {
                builderWithW.append(word.toLowerCase()).append(" ");
                wWords++;
            }
        }
        if (builderWithW.toString().isEmpty()) {
            return new String[0];
        }
        String wWordsSting = builderWithW.toString();
        String[] arr = wWordsSting.split(" ");
        Arrays.sort(arr);
        return arr;
    }
}
