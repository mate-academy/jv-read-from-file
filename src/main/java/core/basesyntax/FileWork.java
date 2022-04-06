package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] split = fileToString(fileName).split("\\W+");
        if (counterOfSizeArray(split) == 0) {
            return new String[0];
        }
        return createFinaArray(split);
    }

    private String[] createFinaArray(String[] splitFileName) {
        String[] result = new String[counterOfSizeArray(splitFileName)];
        int index = 0;
        for (int i = 0; i < splitFileName.length; i++) {
            String toLowerCase = splitFileName[i].toLowerCase();
            if (toLowerCase.startsWith(SPECIFIED_CHARACTER)) {
                result[index] = toLowerCase;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private String fileToString(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader
                     = new BufferedReader(new FileReader(fileName));) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        return stringBuilder.toString();
    }

    private int counterOfSizeArray(String[] array) {
        int counter = 0;
        for (String s : array) {
            if (s.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                counter++;
            }
        }
        return counter;
    }
}
