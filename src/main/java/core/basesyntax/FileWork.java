package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> strings;
        File file = new File(fileName);
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] wordsArray = strings.toString().split("\\W+");
        var filterWordsList = new ArrayList<String>();
        for (String word: wordsArray) {
            if (word.toLowerCase().startsWith("w")) {
                filterWordsList.add(word.toLowerCase());
            }
        }
        String[] filterWordArray = new String[filterWordsList.size()];
        for (int i = 0; i < filterWordsList.size(); i++) {
            filterWordArray[i] = filterWordsList.get(i);

        }
        Arrays.sort(filterWordArray);
        return filterWordArray;
    }
}
