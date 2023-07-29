package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DEFINED_CHARACTER = "w";
    private static final String SPLIT_OPERATION_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder fileRead = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                fileRead.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("I/O operation interrupted.", e);
        }
        if (String.valueOf(fileRead).isEmpty() || String.valueOf(fileRead).isBlank()) {
            return new String[0];
        }
        String[] fileReadSplit =
                String.valueOf(fileRead).toLowerCase().split(SPLIT_OPERATION_REGEX);
        Arrays.sort(fileReadSplit);
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < fileReadSplit.length; i++) {
            if (startIndex == 0 && fileReadSplit[i].startsWith(DEFINED_CHARACTER)) {
                startIndex = i;
            }
            if (startIndex > 0 && !fileReadSplit[i].startsWith(DEFINED_CHARACTER)) {
                endIndex = i;
                break;
            }
            if (startIndex > 0 && i == fileReadSplit.length - 1) {
                endIndex = i + 1;
            }
        }
        return Arrays.copyOfRange(fileReadSplit, startIndex, endIndex);
    }
}
