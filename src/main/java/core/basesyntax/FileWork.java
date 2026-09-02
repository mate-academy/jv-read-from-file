package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.startsWith("w") || word.startsWith("W")) {
                        result.add(checkForPunctuation(word));
                    }
                }
            }
            Collections.sort(result);
            String[] words = result.toArray(new String[result.size()]);
            return words;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String checkForPunctuation(String word) {
        return word.replaceAll("\\p{Punct}", "").toLowerCase();
    }
}
