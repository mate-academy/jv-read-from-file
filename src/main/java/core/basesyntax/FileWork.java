package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String REGEX = "\\s*(\\s|,|\\?|!|\\.)\\s*";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            if (line == null) {
                return new String[0];
            }
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                String[] words = line.toLowerCase(Locale.ROOT).split(REGEX);
                for (String word : words) {
                    if (word.indexOf("w") == 0) {
                        builder.append(word).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
            String[] result = builder.toString().split(" ");
            Arrays.sort(result);
            if (result.length == 1) {
                return new String[0];
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t find or read file", e);
        }
    }
}
