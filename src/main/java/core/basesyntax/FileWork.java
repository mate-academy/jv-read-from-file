package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            ArrayList<String> filteredWords = new ArrayList<>();
            for (String string: strings) {
                String[] words = string.split("\\W+");
                for (String eachWord: words) {
                    eachWord = eachWord.toLowerCase();
                    if (eachWord.startsWith("w")) {
                        filteredWords.add(eachWord);
                    }
                }
            }
            Collections.sort(filteredWords);
            return filteredWords.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
