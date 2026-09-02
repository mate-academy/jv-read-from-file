package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final int ARRAY_LIMIT = 500;
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        char[] array = new char[ARRAY_LIMIT];
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            reader.read(array);
        } catch (IOException e) {
            throw new RuntimeException("File can't be read", e);
        }
        String[] words = String.valueOf(array).toLowerCase().split("\\W");
        int counter = 0;
        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                counter++;
            }
        }
        int index = 0;
        String[] result = new String[counter];
        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                result[index] = word;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
