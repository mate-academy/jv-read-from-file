package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        int counterW = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file data", e);
        }
        String[] allWorlds = stringBuilder.toString().split("\\W+");
        for (String word: allWorlds) {
            if (word.length() != 0 && word.substring(0, 1).equalsIgnoreCase("w")) {
                counterW++;
            }
        }
        String[] result = new String[counterW];
        int index = 0;
        for (String word: allWorlds) {
            if (word.length() != 0 && word.substring(0, 1).equalsIgnoreCase("w")) {
                result[index] = word.toLowerCase();
                index++;
            }
        }
        Arrays.sort(result);
        return counterW == 0 ? new String[0] : result;
    }
}
