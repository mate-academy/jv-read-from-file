package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> wordsList = new ArrayList<>();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            for (String line : strings) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        wordsList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }

        String[] filteredWords = wordsList.toArray(new String[0]);

        Arrays.sort(filteredWords);

        return filteredWords;
    }
}
