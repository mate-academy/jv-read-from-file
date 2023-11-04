package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder dataFromFile = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                dataFromFile.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot open file " + e);
        }
        String[] split = dataFromFile.toString().split("\\W");
        int k = 0;
        for (String s : split) {
            if (s.matches("(\\b[w,W]\\w+)")) {
                k++;
            }
        }
        String[] result = new String[k];
        k = 0;
        for (String s : split) {
            if (k == result.length) {
                break;
            }
            if (s.matches("(\\b[w,W]\\w+)")) {
                result[k] = s.toLowerCase();
                k++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
