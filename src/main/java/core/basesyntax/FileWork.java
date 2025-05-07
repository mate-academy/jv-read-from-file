package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String read = bufferedReader.readLine();
            if (read == null) {
                return new String[]{};
            }
            while (read != null) {
                stringBuilder.append(read).append(" ");
                read = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
        String[] temp = stringBuilder.toString().split(REGEX);
        StringBuilder tempBuilder = new StringBuilder();
        for (String word : temp) {
            if (word.toLowerCase().startsWith("w")) {
                tempBuilder.append(word.toLowerCase()).append(" ");
            }
        }
        if (tempBuilder.toString().length() == 0) {
            return new String[]{};
        }
        String[] result = tempBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
