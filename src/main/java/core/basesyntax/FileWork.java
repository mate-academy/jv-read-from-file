package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    private static final String WORD_DELIMITER = "[\\p{Punct}\\s]+";
    private static final String STARTS_WITH_W = "^[Ww].*";

    public String[] readFromFile(String fileName) {
        ArrayList<String> words = readWords(fileName);
        ArrayList<String> result = filterAndSort(words);
        return result.toArray(String[]::new);
    }

    private ArrayList<String> readWords(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String lineFromFile = reader.readLine();
            while (lineFromFile != null) {
                words.addAll(Arrays.asList(lineFromFile.split(WORD_DELIMITER)));
                lineFromFile = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Can`t read data from file " + fileName + e);
        }
        return words;
    }

    private ArrayList<String> filterAndSort(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.matches(STARTS_WITH_W)) {
                result.add(word.toLowerCase());
            }
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
