package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String REGEXP_STRING_PATTERN = "\\W+";
    private static final String CHECK_STARTS_WITH_CHAR = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringAccumulator = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String lastLine = reader.readLine();
            while (lastLine != null) {
                stringAccumulator.append(lastLine.toLowerCase()).append(System.lineSeparator());
                lastLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }

        String[] splitedStringWithRegexp = stringAccumulator.toString()
                .split(REGEXP_STRING_PATTERN);
        return sortStringsArray(filterStringsArrayForFirstChar(splitedStringWithRegexp));
    }

    private String[] filterStringsArrayForFirstChar(String[] stringArray) {
        StringBuilder filteredString = new StringBuilder();
        for (String string : stringArray) {
            if (string.startsWith(CHECK_STARTS_WITH_CHAR)) {
                filteredString.append(string).append(" ");
            }
        }
        return filteredString.isEmpty() ? new String[0] : filteredString.toString().split(" ");
    }

    private String[] sortStringsArray(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String temporary = array[j];
                    array[j] = array[i];
                    array[i] = temporary;
                }
            }
        }
        return array;
    }
}
