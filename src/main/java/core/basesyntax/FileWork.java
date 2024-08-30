package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            for (String line : lines) {
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (word.startsWith("W")) {
                        wordsList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Can't filter file w/ name - " + fileName);
        }
        String[] result = wordsList.toArray(new String[0]);
        Arrays.sort(result);

        return result;
    }
}
