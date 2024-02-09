package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String readLine = null;
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] strArray = readLine.split("\\s+");
                for (String s : strArray) {
                    if (s.toLowerCase().startsWith("w")) {
                        filteredWords.add(s.toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", ""));
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(filteredWords);
        return filteredWords.toArray(new String[0]);
    }
}
