package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DELIMITER = "\\W+";
    private static final String DELIMITER_FOR_RESULT = " ";
    private static final char LETTER = 'w';
    private static final int INDEX_FOR_NEW_FILE = 0;

    public String[] readFromFile(String fileName) {
        try (BufferedReader readerFromFile = new BufferedReader(new FileReader(fileName))) {
            StringBuilder fileContent = new StringBuilder();
            String value = readerFromFile.readLine();
            if (value == null) {
                return new String[] {};
            }
            while (value != null) {
                fileContent.append(value).append(System.lineSeparator());
                value = readerFromFile.readLine();
            }
            String[] fileContentByWords = fileContent.toString().toLowerCase().split(DELIMITER);
            Arrays.sort(fileContentByWords);
            StringBuilder sortedDataFromFile = new StringBuilder();
            for (int i = 0; i < fileContentByWords.length; i++) {
                if (fileContentByWords[i].charAt(INDEX_FOR_NEW_FILE) == LETTER) {
                    sortedDataFromFile.append(fileContentByWords[i])
                            .append(DELIMITER_FOR_RESULT);
                }
            }
            if (sortedDataFromFile.toString().split(DELIMITER_FOR_RESULT).length == 1) {
                return new String[] {};
            } else {
                return sortedDataFromFile.toString().split(DELIMITER_FOR_RESULT);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + fileName, e);
        }
    }
}
