package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            int value = fileReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to find a file: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from a file: " + fileName, e);
        }

        String[] words = stringBuilder.toString().split("\\W+");
        int amountOfWords = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (words[i].length() > 0 && words[i].charAt(0) == 'w') {
                amountOfWords++;
            }
        }

        String[] result = new String[amountOfWords];
        for (int i = 0, j = 0; i < words.length; i++) {
            if (words[i].length() > 0 && words[i].charAt(0) == 'w') {
                result[j++] = words[i];
            }
        }

        Arrays.sort(result);
        return result;
    }
}
