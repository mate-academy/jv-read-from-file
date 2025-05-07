package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final String SPLITTER = " ";

    public String[] readFromFile(String fileName) {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            int value = bufferedReader.read();
            if (value == 0) {
                return new String[0];
            }
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
            line = builder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String[] splitter = line.split(REGEX);
        StringBuilder compiler = new StringBuilder();
        for (int i = 0; i < splitter.length; i++) {
            if (splitter[i].indexOf("w") == 0) {
                compiler.append(splitter[i]).append(SPLITTER);
            }
        }
        if (compiler.length() == 0) {
            return new String[0];
        }
        String[] result = compiler.toString().split(REGEX);
        Arrays.sort(result);
        return result;
    }
}
