package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String START_LETTER = "w";
    private static final String REGEX_NON_WORD = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder readedFile = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new String[0];
            }
            while (line != null) {
                readedFile.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String[] arrayOfFile = readedFile.toString().split(REGEX_NON_WORD);
        StringBuilder builderWithResultWord = new StringBuilder();
        for (String word : arrayOfFile) {
            if (word.toLowerCase().startsWith(START_LETTER)) {
                builderWithResultWord.append(word.toLowerCase()).append(System.lineSeparator());
            }
        }
        if (builderWithResultWord.toString().isEmpty()) {
            return new String[0];
        }
        String[] resultArray = builderWithResultWord.toString().split(System.lineSeparator());
        return sortArray(resultArray);
    }

    public static String[] sortArray(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
