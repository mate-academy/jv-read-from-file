package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result = new String[0];
        int count = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.toLowerCase().split("\\W+");
                line = bufferedReader.readLine();
                for (String word : splitLine) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        result = Arrays.copyOf(result, result.length + 1);
                        result[count++] = word;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Arrays.sort(result);
        return result;
    }
}
