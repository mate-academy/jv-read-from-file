package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    // private String fileName = "test2";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        // try-with-resources: Scanner will be closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value);
                builder.append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file.", e);
        }
        String[] words = builder.toString().toLowerCase().split("[\\p{Punct}\\s]+");
        List<String> wordsWithW = new ArrayList<>();
        for (String word : words) {
            if (word.indexOf("w") == 0) {
                wordsWithW.add(word);
            }
        }
        Collections.sort(wordsWithW);

        String[] list = new String[wordsWithW.size()];
        list = wordsWithW.toArray(list);
        return list;
    }
}
