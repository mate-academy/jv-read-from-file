package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(new File(fileName)))) {
            int value = bufferedReader.read();

            StringBuilder stringBuilder = new StringBuilder();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }

            if (stringBuilder.isEmpty()) {
                return new String[0];
            }
            String[] words = stringBuilder.toString().split("[^a-zA-Z0-9]+");

            stringBuilder.delete(0, stringBuilder.length());
            for (int i = 0; i < words.length; i++) {
                if (words[i].toLowerCase().toCharArray()[0] == 'w') {
                    stringBuilder.append(words[i].toLowerCase()).append(" ");
                }
            }
            if (stringBuilder.isEmpty()) {
                return new String[0];
            }
            words = stringBuilder.toString().split(" ");
            Arrays.sort(words);
            return words;
        } catch (IOException e) {
            throw new RuntimeException("Can't open the file!", e);
        }
    }
}
