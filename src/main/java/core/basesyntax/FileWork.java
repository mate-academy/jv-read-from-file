package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] filteredArray = new String[0];
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                        filteredArray = resizeArray(filteredArray, count + 1);
                        filteredArray[count++] = cleanWord;
                        Arrays.sort(filteredArray);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + e.getMessage());
        }
        return filteredArray;
    }

    private String[] resizeArray(String[] array, int newSize) {
        String[] newArray = new String[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        return newArray;
    }
}
