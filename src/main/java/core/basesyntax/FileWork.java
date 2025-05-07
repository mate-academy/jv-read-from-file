package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null || value.length() == 0) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().toLowerCase().split(" ");
            stringBuilder.setLength(0);
            int counter = 0;
            for (int i = 0; i < words.length; i++) {
                int last = words[i].length() - 1;
                if (words[i].charAt(0) == 'w') {
                    if (!(Character.isLetter(words[i].charAt(last)))) {
                        words[i] = words[i].substring(0, last);
                    }
                    stringBuilder.append(words[i]).append(" ");
                    counter += 1;
                }
            }
            if (counter == 0) {
                return new String[0];
            }
            String[] exitArray = stringBuilder.toString().split(" ");
            Arrays.sort(exitArray);
            return exitArray;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }
}
