package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String valueOfLane = bufferedReader.readLine();
            if (valueOfLane == null) {
                return new String[0];
            }
            String[] words;
            while (valueOfLane != null) {
                words = valueOfLane.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word).append(System.lineSeparator());
                    }
                }
                valueOfLane = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split(System.lineSeparator());
        Arrays.sort(result);
        return result;
    }
}
