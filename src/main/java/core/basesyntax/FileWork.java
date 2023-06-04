package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final String SPLITTER = "[^\\p{L}]+";
    private static final String SPECIFIED_CHAR = "w";
    private StringBuilder stringBuilder = new StringBuilder();
    private List<String> specifiedWords = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String text = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] splittedText = text.split(SPLITTER);

            return sortArray(splittedText, SPECIFIED_CHAR);
        } catch (IOException e) {
            throw new RuntimeException("Something is wrong", e);
        }
    }

    private String[] sortArray(String[] arrayToSort, String specifiedChar) {
        List<String> sortedList = new ArrayList<>();

        for (String word : arrayToSort) {
            word = word.toLowerCase();
            if (word.startsWith(specifiedChar)) {
                sortedList.add(word);
            }
        }
        sortedList.sort(Comparator.naturalOrder());

        return sortedList.toArray(new String[sortedList.size()]);
    }

}
