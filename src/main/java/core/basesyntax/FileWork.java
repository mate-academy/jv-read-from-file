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

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }

                    String lowerWord = word.toLowerCase();
                    if (lowerWord.startsWith("w")) {
                        resultList.add(lowerWord);
                    }
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }

        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }
}
