package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                String[] split = value.split("\\W+");
                for (String word : split) {
                    if (word.toLowerCase().charAt(0) == 'w') {
                        result.append(word.toLowerCase()).append(" ");
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (result.isEmpty()) {
            return new String[0];
        }
        String[] resultArray = result.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
