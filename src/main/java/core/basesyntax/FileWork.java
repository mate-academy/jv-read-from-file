package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String DELETED_WORD = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(" ");
                line = reader.readLine();
            }
            String [] word = builder.toString().split(" ");
            List<String> result = new ArrayList<>();
            for (String words : word) {
                if (words.startsWith(DELETED_WORD)
                        || words.startsWith(DELETED_WORD.toUpperCase())) {
                    String correctWord = words.replaceAll("[^a-zA-Z]+", "");
                    result.add(correctWord.toLowerCase());
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can not read the file", e);
        }
    }
}
