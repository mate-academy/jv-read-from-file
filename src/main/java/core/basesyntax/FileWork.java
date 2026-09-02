package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public static String[] readFromFile(String fileName) {
        try {
            List<String> fileLines = Files.readAllLines(Paths.get(fileName));
            ArrayList<String> goodWords = new ArrayList<>();
            for (String fileLine : fileLines) {
                String[] words = fileLine.split("\\W+");
                for (String word : Arrays.asList(words)) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        goodWords.add(word.toLowerCase());
                    }
                }
            }
            String[] result = goodWords.toArray(new String[0]);
            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            throw new RuntimeException("Помилка при читанні файлу: " + e.getMessage());
        }

    }
}
