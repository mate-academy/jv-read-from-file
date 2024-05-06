package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String PATTERN = "\\b[wW]\\w*\\b[.,;:?!]?";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            String[] res;
            while ((line = bufferedReader.readLine()) != null) {
                res = line.split(" ");
                for (String s : res) {
                    if (s.matches(PATTERN)) {
                        stringBuilder.append(s.toLowerCase()).append(" ");
                    }
                }
            }
            if (stringBuilder.length() == 0) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

        String[] res = stringBuilder.toString().split("[.,;:?!\\s]+");
        Arrays.sort(res);
        return res;
    }
}
