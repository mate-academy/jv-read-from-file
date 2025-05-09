package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can`t read the text", e);
        }
        String content = stringBuilder.toString();
        String[] tokens = content.split("\\W+");
        int count = 0;
        for (String token : tokens) {
            if (token.toLowerCase().startsWith("w")) {
                count++;
            }
        }
        String[] words = new String[count];
        int idx = 0;
        for (String t : tokens) {
            String lower = t.toLowerCase();
            if (lower.startsWith("w")) {
                words[idx++] = lower;
            }
        }
        Arrays.sort(words);
        return words;
    }
}
