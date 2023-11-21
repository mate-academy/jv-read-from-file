package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        int firstCount = 0;
        int secondCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String pull = reader.readLine();
            if (pull == null) {
                return new String[0];
            }
            while (pull != null) {
                stringBuilder.append(pull).append(System.lineSeparator());
                pull = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] split = stringBuilder.toString().split("\\W+");

        for (String index: split) {
            if (index.charAt(0) == 'w' | index.charAt(0) == 'W') {
                firstCount++;
            }
        }
        String[] result = new String[firstCount];

        for (String index: split) {
            if (index.charAt(0) == 'w' | index.charAt(0) == 'W') {
                result[secondCount] = index.toLowerCase();
                secondCount++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
