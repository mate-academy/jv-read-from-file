package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
            int counter = 0;
            for (String word:words) {
                if (word.length() > 0 && word.charAt(0) == 'w') {
                    counter++;
                }
            }
            int indexResult = 0;
            result = new String[counter];
            for (String word:words) {
                if (word.length() > 0 && word.charAt(0) == 'w') {
                    result[indexResult++] = word;
                }
            }
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return result;
    }
}
