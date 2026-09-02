package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder fullText = new StringBuilder();
        String line;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                fullText.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("file was didn't working", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("file was didn't working", e);
            }
        }

        String[] words = fullText.toString().split("[^a-zA-Z]+");
        List<String> filtered = new ArrayList<>();

        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                filtered.add(word.toLowerCase());
            }
        }

        Collections.sort(filtered);

        return filtered.toArray(new String[0]);
    }
}
