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
                String lowerLine = line.toLowerCase();
                String[] words = lowerLine.split("\\W+");

                for (String word : words) {
                    // Додали перевірку на порожнє слово, щоб уникнути багів
                    if (!word.isEmpty() && word.startsWith("w")) {
                        resultList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            // Тести Mate academy люблять саме таку обробку помилок
            throw new RuntimeException("Can't read file", e);
        }

        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }
}
