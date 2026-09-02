package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s\\p{Punct}]+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        String cleanWord = word.replaceAll("\\p{Punct}", "").toLowerCase();

                        if (cleanWord.startsWith("w")) {
                            wordsList.add(cleanWord);
                        }
                    }
                }
            }
        } catch (IOException e) {
            return new String[0];
        }

        String[] result = wordsList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
