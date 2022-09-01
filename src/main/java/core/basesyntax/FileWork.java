package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result;
        try {
            result = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String[] wordsArray = result.toString().split("\\W+");
        var filteredWordsList = new ArrayList<String>();
        for (String word : wordsArray) {
            if (word.toLowerCase().startsWith("w")) {
                filteredWordsList.add(word.toLowerCase());
            }
        }
        String[] filteredWordsArray = new String[filteredWordsList.size()];
        for (int i = 0; i < filteredWordsList.size(); i++) {
            filteredWordsArray[i] = filteredWordsList.get(i);
        }
        Arrays.sort(filteredWordsArray);
        return filteredWordsArray;
    }
}
