package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String content = builder.toString().toLowerCase().replace(".", "");
            String[] words = content.split("\\W+");
            List<String> result = new ArrayList<String>();
            for (String word: words) {
                if (word.startsWith(FIRST_LETTER)) {
                    result.add(word);
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cant read file:", e);
        }
    }
}
