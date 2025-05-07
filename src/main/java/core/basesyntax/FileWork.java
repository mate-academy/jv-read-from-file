package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] split;
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName))) {
            if (fileName.isEmpty()) {
                return new String[0];
            }
            split = bufferedReader.lines()
                    .collect(Collectors.joining(System.lineSeparator()))
                    .split("\\W+");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int count = 0;
        for (String each : split) {
            if (each.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        String[] resultArray = new String[count];
        for (int i = 0, j = 0; i < split.length; i++) {
            if (split[i].toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                resultArray[j] = split[i].toLowerCase();
                j++;
            }
        }
        Arrays.sort(resultArray);
        return resultArray;
    }
}
