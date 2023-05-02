package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = reader.readLine();
            }
            String[] words = stringBuilder
                    .toString()
                    .split(" ");
            List<String> result = new ArrayList<>();
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)
                        || word.startsWith(SPECIFIED_CHARACTER.toUpperCase())) {
                    String modifyWord = word.replaceAll("[^a-zA-Z]+", "");
                    result.add(modifyWord.toLowerCase());
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read", e);
        }
    }
}
