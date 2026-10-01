package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String REGEX = "[\\s\\p{Punct}]+";

    private void processWords(String[] words, List<String> resultList) {
        if (words == null) {
            return;
        }
        for (String word : words) {
            word = word.toLowerCase();
            if (word.startsWith("w")) {
                resultList.add(word);
            }
        }
    }

    public String[] readFromFile(String fileName) throws RuntimeException {
        List<String> resultList = new ArrayList<>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new RuntimeException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(REGEX);
                processWords(words, resultList);
            }
            Collections.sort(resultList);
            return resultList.toArray(new String[0]);
        } catch (IOException | RuntimeException e) {
            return new String[0];
        }
    }
}
