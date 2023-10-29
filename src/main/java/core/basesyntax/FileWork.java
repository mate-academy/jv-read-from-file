package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> listCorrectWords = new ArrayList<>();
        try {
            List<String> stringsList =
                    Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8);
            if (stringsList.size() == 0) {
                return new String[0];
            }
            for (String string : stringsList) {
                String[] words = string.split("\\W+");
                for (String word : words) {
                    if (word.toLowerCase().charAt(0) == 'w') {
                        listCorrectWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(listCorrectWords);
        String[] result = new String[listCorrectWords.size()];
        listCorrectWords.toArray(result);
        return result;
    }
}
