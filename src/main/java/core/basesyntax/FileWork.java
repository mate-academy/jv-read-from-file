package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_SPLITTER = "\\W+";
    private static final String STARTS_WITH = "w";
    private static final String SPLIT_DELIMITER = " ";

    public String[] readFromFile(String fileName) {
        String[] result = {};
        StringBuilder filteredWords = new StringBuilder();
        String[] currentLineArray;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                currentLineArray = currentLine.toLowerCase().split(REGEX_SPLITTER);
                for (String currentString : currentLineArray) {
                    if (currentString.startsWith(STARTS_WITH)) {
                        filteredWords.append(currentString).append(SPLIT_DELIMITER);
                    }
                }
                currentLine = bufferedReader.readLine();
            }
            if (filteredWords.length() == 0) {
                return result;
            }
            result = filteredWords.toString().split(SPLIT_DELIMITER);
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return result;
    }
}
