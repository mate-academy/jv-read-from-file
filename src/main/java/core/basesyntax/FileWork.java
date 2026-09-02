package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String START_CHAR = "w";
    private static final String SPLITTER = "\\W+";
    private int arrLength = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                content.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (content.length() == 0) {
            return new String[]{};
        }

        String[] words = content.toString().toLowerCase().split(SPLITTER);
        for (String s : words) {
            if (s.startsWith(START_CHAR)) {
                arrLength++;
            }
        }
        String[] result = new String[arrLength];
        int i = 0;
        for (String s : words) {
            if (s.startsWith(START_CHAR)) {
                result[i] = s;
                i++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
