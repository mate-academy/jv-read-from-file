package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    private static final String STARTING_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String input;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            input = reader.readLine();
            if (input == null) {
                return new String[0];
            }
            while (input != null) {
                builder.append(input).append(" ");
                input = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String output = builder.toString();
        return filterData(output);
    }

    private String[] filterData(String allWords) {
        String[] array = allWords.split("\\W+");
        int count = 0;
        for (String word : array) {
            if (word.toLowerCase().startsWith(STARTING_LETTER)) {
                count++;
            }
        }
        String[] finalResult = new String[count];
        int index = 0;
        for (String word : array) {
            if (word.toLowerCase().startsWith(STARTING_LETTER)) {
                finalResult[index] = word.toLowerCase();
                index++;
            }
        }
        Arrays.sort(finalResult, Comparator.naturalOrder());
        return finalResult;
    }
}
