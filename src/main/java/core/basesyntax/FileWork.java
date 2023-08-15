package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String SPLIT_PATTER = "\\W+";

    public String[] readFromFile(String fileName) {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(SPLIT_PATTER);
                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {
                        result.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read the file ", e);
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
