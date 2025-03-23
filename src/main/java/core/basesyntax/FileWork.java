package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {

        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            StringBuilder builder = new StringBuilder();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            String[] builderArray = builder.toString().toLowerCase().split("\\W+");
            for (String word : builderArray) {
                if (word.startsWith("w")) {
                    wordsStartingWithW.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file", e);
        }

        String[] resultArray = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
