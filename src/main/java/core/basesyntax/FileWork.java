package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            String words = stringBuilder.toString();
            if (words.isEmpty()) {
                String[] isEmpty = {};
                return isEmpty;
            }
            String[] split = words.split("\\W+");
            int amountOfCurrentWords = 0;
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].toLowerCase();
                if (split[i].indexOf('w') == 0) {
                    amountOfCurrentWords++;
                }
            }
            String[] currentWords = new String[amountOfCurrentWords];
            int count = 0;
            for (int i = 0; i < split.length; i++) {
                if (split[i].indexOf('w') == 0) {
                    currentWords[count] = split[i];
                    count++;
                }
            }
            Arrays.sort(currentWords);
            return currentWords;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }
    }
}
