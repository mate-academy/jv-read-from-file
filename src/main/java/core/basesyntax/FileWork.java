package core.basesyntax;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] resultArray = new String[0];
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            FileReader reader = new FileReader(file);
            FileReader readerCheck = new FileReader(file);
            if (readerCheck.read() == -1) {
                return resultArray;
            }
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t open file");
        }

        String[] split = builder.toString().split("\\W+");
        StringBuilder result = new StringBuilder();
        for (String string : split) {
            if (string.toLowerCase().charAt(0) == 'w') {
                result.append(string).append(" ");
            }
        }
        if (result.toString() == "") {
            return resultArray;
        }
        resultArray = result.toString().toLowerCase().split("\\W+");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
