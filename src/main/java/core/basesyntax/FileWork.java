package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File inputFile = new File(fileName);
        String lineFromFile;
        StringBuilder stringWithSpecChar = new StringBuilder();
        String[] retString;
        try (BufferedReader inputBufRdrFileReader = new BufferedReader(new FileReader(inputFile))) {
            while ((lineFromFile = inputBufRdrFileReader.readLine()) != null) {
                String[] splittedLineFromFile = lineFromFile.split("[ .,!?:;]");
                for (String word : splittedLineFromFile) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    stringWithSpecChar.append((word.toLowerCase()
                            .startsWith(SPECIFIED_CHARACTER)) ? word + " " : "");
                }
            }
            retString = stringWithSpecChar.isEmpty() ? new String[0]
                    : stringWithSpecChar.toString().toLowerCase().split(" ");
            Arrays.sort(retString);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        return retString;
    }
}
