package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> readLinesList;
        List<String> resultList = new ArrayList<>();
        File file = new File(fileName);
        try {
            readLinesList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read lines from file!");
        }

        for (String line : readLinesList) {
            for (String word : line.split("\\W+")) {
                if (word.startsWith("W") || word.startsWith("w")) {
                    resultList.add(word.toLowerCase());
                }
            }
        }
        String[] finalArray = new String[resultList.size()];
        resultList.toArray(finalArray);
        Arrays.sort(finalArray);
        return finalArray;
    }
}
