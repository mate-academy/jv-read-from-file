package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] readData = readData(fileName);
        String[] wordsArray = generateWordsArray(readData);

        return filterAndSort(wordsArray);
    }

    private String[] readData(String fileName) {
        Path pathOfFile = Path.of(fileName);
        try {
            List<String> lines = Files.readAllLines(pathOfFile);
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file : " + fileName, e);
        }
    }

    private String[] generateWordsArray(String[] rawData) {
        List<String> separatedWords = new ArrayList<String>();
        for (String row : rawData) {
            String[] separatedLine = row.split("\\W+");
            separatedWords.addAll(Arrays.asList(separatedLine));
        }
        return separatedWords.toArray(new String[0]);
    }

    private String[] filterAndSort(String[] words) {
        List<String> filteredList = new ArrayList<String>();
        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                filteredList.add(word.toLowerCase());
            }
        }
        filteredList.sort(Comparator.naturalOrder());
        return filteredList.toArray(new String[0]);
    }
}
