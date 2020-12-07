package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARACTER_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder readFile = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();

            while (value != null) {
                readFile.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't ride file", e);
        }

        String[] fileReadAndSplit = readFile.toString().toLowerCase().split(" ");
        StringBuilder fileWriteToArray = new StringBuilder();

        for (String findCharacterW : fileReadAndSplit) {
            String temp = findCharacterW.replaceAll("[.!?]", "");
            if (temp.startsWith(CHARACTER_W)) {
                fileWriteToArray.append(temp).append(" ");
            }
        }

        String[] wordsWithCharacterW = fileWriteToArray.toString().split(" ");
        Arrays.sort(wordsWithCharacterW);

        if (fileWriteToArray.toString().isEmpty()) {
            return new String[0];
        }
        return wordsWithCharacterW;
    }
}
