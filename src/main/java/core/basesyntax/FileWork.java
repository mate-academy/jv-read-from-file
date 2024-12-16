package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
            String[] split = stringBuilder.toString().split("\\W+");
            StringBuilder lineSort = new StringBuilder();
            for (String string : split) {
                if (string.toLowerCase().indexOf("w") == 0) {
                    lineSort.append(string.toLowerCase()).append(" ");
                }
            }
            if (lineSort.toString().isEmpty()) {
                return new String[0];
            }
            String[] sortedArray = lineSort.toString().split(" ");
            Arrays.sort(sortedArray);
            return sortedArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
    }
}
