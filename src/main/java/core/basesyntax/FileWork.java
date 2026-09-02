package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split(SEPARATOR);
                for (String word : words) {
                    if (word.charAt(0) == 'w') {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append(SEPARATOR);
                        }
                        stringBuilder.append(word.replaceAll("[^a-z]", ""));
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!", e);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        }
        String[] returnValues = stringBuilder.toString().split(SEPARATOR);
        Arrays.sort(returnValues);
        return returnValues;
    }
}
