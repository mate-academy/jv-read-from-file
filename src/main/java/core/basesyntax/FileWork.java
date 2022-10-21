package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        String[] result = new String[list.size()];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\W+")) {
                    if (word.toLowerCase().startsWith("w")) {
                        list.add(word.toLowerCase());
                    }
                }
            }
            Collections.sort(list);
            return list.toArray(result);
        } catch (IOException a) {
            throw new RuntimeException("there is no such file");
        }
    }
}
