package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t open file");
        }
        String[] split = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder stringBuilder2 = new StringBuilder();
        for (var i : split) {
            if (i.charAt(0) == 'w') {
                stringBuilder2.append(i).append(" ");
            }
        }
        if (stringBuilder2.isEmpty()) {
            return new String[0];
        }
        split = stringBuilder2.toString().split(" ");
        Arrays.sort(split);
        return split;
    }
}
