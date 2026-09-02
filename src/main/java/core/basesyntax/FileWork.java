package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        StringBuilder lowerWord = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.startsWith(SPECIFIED_CHARACTER) && !word.isEmpty()) {
                        lowerWord.append(word).append(System.lineSeparator());
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = lowerWord.toString();
        String[] resultArray = result.split(System.lineSeparator());

        if (resultArray.length == 1 && resultArray[0].isEmpty()) {
            return new String[0];
        }
        Arrays.sort(resultArray);
        return resultArray;
    }
}
