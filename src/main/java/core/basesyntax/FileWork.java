package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        String[] array = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new String[]{};
            }
            while (line != null) {
                String[] split = line.split("\\W+");
                for (String word : split) {
                    if (word.substring(0, 1).equals("W") || word.substring(0, 1).equals("w")) {
                        builder.append(word).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (builder.length() == 0) {
            return new String[]{};
        }
        array = builder.toString().toLowerCase().split(" ");
        Arrays.sort(array);
        return array;
    }
}
