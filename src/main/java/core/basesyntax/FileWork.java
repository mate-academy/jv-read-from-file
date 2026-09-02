package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String fileLine = bufferedReader.readLine();

            while (fileLine != null) {
                String[] fileWords = fileLine.toLowerCase().split("\\W+");
                for (String word : fileWords) {
                    if (word.startsWith("w")) {
                        list.add(word);
                    }
                }
                fileLine = bufferedReader.readLine();
            }
            Collections.sort(list);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from from file: " + fileName, e);
        }
        return list.toArray(new String[0]);
    }
}
