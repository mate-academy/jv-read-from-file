package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }

            String[] wordsFromFile = stringBuilder.toString().split("[^a-zA-Z]+");
            String[] exclusiveWords = keepRequiredWords(wordsFromFile);
            Arrays.sort(exclusiveWords);
            return exclusiveWords;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesn't exist", e);
        } catch (IOException e) {
            throw new RuntimeException("The file is not able to be read", e);
        }
    }

    private String[] keepRequiredWords(String[] entireText) {
        int count = 0;
        for (String word : entireText) {
            if (word.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        String[] specificWords = new String[count];
        int index = 0;

        for (String word : entireText) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                specificWords[index] = word.toLowerCase();
                index++;
            }
        }

        return specificWords;
    }
}
