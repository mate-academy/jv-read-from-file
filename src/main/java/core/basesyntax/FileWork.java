package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String[] words;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words = line.split("\\s+");
                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {
                        String filtered = word.replaceAll("[^\\p{Alnum}]", "").toLowerCase();
                        if (!filtered.isEmpty()) {
                            result = addWordToArray(result, filtered);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
        Arrays.sort(result);
        return result;
    }

    private String[] addWordToArray(String[] array, String word) {
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = word;
        return newArray;
    }
}

