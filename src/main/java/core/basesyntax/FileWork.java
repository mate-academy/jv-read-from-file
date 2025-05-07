package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader((fileName)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file!", e);
        }
        String [] words = stringBuilder.toString().split("\\W+");
        int count = 0;
        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                count++;
            }
        }
        if (count != 0) {
            String [] result = new String[count];
            int i = 0;
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    result[i] = word.toLowerCase();
                    i++;
                }
            }
            Arrays.sort(result);
            return result;
        } else {
            return new String[]{};
        }

    }
}
