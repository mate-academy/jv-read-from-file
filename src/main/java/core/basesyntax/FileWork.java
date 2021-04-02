package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String REGEX = "\\s*(\\s|,|\\?|!|\\.)\\s*";
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                String[] words = line.toLowerCase(Locale.ROOT).split(REGEX);
                for (String word : words) {
                    if (word.startsWith(FIRST_LETTER)) {
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
