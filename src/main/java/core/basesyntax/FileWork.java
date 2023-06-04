package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result = new String[0];
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.toLowerCase().split("\\W+");
                for (String wordW : data) {
                    if (wordW.startsWith("w")) {
                        result = Arrays.copyOf(result, result.length + 1);
                        result[count++] = wordW;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        Arrays.sort(result);
        return result;
    }
}
