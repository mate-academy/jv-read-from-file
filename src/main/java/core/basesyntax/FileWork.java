package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String PATTERN_REG = "\\W+";

    public String[] readFromFile(String fileName) {
        String[] inputData = readFile(fileName);

        if (inputData.length == 0) {
            return inputData;
        }

        return findDesiredWords(inputData);
    }

    private String[] readFile(String fileName) {
        File input = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String[] result = new String[0];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

        if (stringBuilder.toString().length() != 0) {
            result = stringBuilder.toString().split(PATTERN_REG);
        }

        return result;
    }

    private String[] findDesiredWords(String[] inputData) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] result = new String[0];

        for (String word:inputData) {
            if (startWithLetter(word.toLowerCase())) {
                stringBuilder.append(word.toLowerCase()).append(System.lineSeparator());
            }
        }

        if (stringBuilder.toString().length() != 0) {
            result = stringBuilder.toString().split(System.lineSeparator());
            Arrays.sort(result);
        }

        return result;
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
