package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> resultList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase()
                        .replaceAll("[^a-z ]", " ")
                        .split(" ");

                for (String word : words) {
                    if (word.startsWith("w")) {
                        resultList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }
}
