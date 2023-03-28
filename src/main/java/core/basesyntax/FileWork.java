package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineWords = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                for (String word : lineWords) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = words.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
