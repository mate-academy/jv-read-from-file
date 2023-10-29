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
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String string = stringBuilder.toString().toLowerCase();
            String[] split = string.split("\\W+");
            int count = 0;
            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith("w")) {
                    count++;
                }
            }
            int index = 0;
            String[] result = new String[count];
            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith("w")) {
                    result[index] = split[i];
                    index++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
    }
}
