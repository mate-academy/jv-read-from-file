package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean firstWord = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
        String[] words = builder.toString().split("\\W+");
        for (String word : words) {
            if (word.startsWith("w") || word.startsWith("W")) {
                if (!firstWord) {
                    result.append(" ");
                }
                result.append(word);
                firstWord = false;
            }
        }
        if (result.length() == 0) {
            return new String[0];
        }
        String[] resultArray = result.toString().toLowerCase().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
