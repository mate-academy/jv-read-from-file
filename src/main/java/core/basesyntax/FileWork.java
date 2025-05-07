package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char LETTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            if (line == null) {
                return new String[0];
            }
            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (line != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (word.charAt(0) == LETTER) {
                        stringBuilder.append(word).append(" ");
                        count++;
                    }
                }
                line = reader.readLine();
            }
            String[] result = stringBuilder.toString().split(" ");
            if (count != 0) {
                Arrays.sort(result);
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("file does not exist", e);
        }
        return new String[0];
    }
}
