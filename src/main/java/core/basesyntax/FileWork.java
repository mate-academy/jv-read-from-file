package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] resultW = new String[0];
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return resultW;
            }
            reader.read();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] split = stringBuilder.toString().toLowerCase().split(" ");
            StringBuilder stringBuilder1 = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].replaceAll("[.!?]", "");
                if (split[i].charAt(0) == 'w') {
                    stringBuilder1 = stringBuilder1.append(split[i]).append(" ");
                }
            }
            resultW = stringBuilder1.toString().split(" ");
            if (stringBuilder1.toString().equals("")) {
                return new String[0];
            }
            Arrays.sort(resultW);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        return resultW;
    }
}
