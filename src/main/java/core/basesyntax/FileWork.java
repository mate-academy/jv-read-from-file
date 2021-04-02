package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> listOfWords = new ArrayList<>();

        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                for (String word : value.split("\\W+")) {
                    if (word.toLowerCase().startsWith(START_LETTER)) {
                        listOfWords.add(word.toLowerCase());
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] result = listOfWords.toArray(new String[0]);
        Arrays.sort(result);
        return result;

    }
}
