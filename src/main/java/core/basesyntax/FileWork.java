package core.basesyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] words = readFile(fileName).split("\\W+");
        if (words[0].equals("")) {
            return new String[0];
        }
        List<String> filtered = new ArrayList<>();
        for (String word : words) {
            if (word.substring(0, 1).equals("w")) {
                filtered.add(word);
            }
        }
        String[] output = new String[filtered.size()];
        for (int i = 0; i < filtered.size(); i++) {
            output[i] = filtered.get(i);
        }
        Arrays.sort(output);
        return output;
    }

    private String readFile(String file) {
        StringBuilder text = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
            while (line != null) {
                text.append(line.toLowerCase()).append(" ");
                line = reader.readLine();
            }
            return text.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
