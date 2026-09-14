package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }

        if (builder.length() == 0) {
            return new String[0];
        }

        String[] words = builder.toString().toLowerCase().split("\\W+");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                result.add(word);
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }
}
