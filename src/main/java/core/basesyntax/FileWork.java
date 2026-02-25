package core.basesyntax;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        List<String> resultList = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    String line;
    while ((line = br.readLine()) != null) {
        String[] words = line.split("[^a-zA-Z]+");
        for(String word: words) {
            word = word.toLowerCase();
            if (!word.isEmpty() && word.startsWith("w")) {
                resultList.add(word);
            }
        }
    }
    } catch (IOException e) {
        throw new RuntimeException("Cant read", e);
    }
        Collections.sort(resultList);

        // 7. По заданию нам нужно вернуть обычный массив String[], а не List.
        // Эта команда превращает список в массив и возвращает его.
        return resultList.toArray(new String[0]);
    }
}
