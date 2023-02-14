package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String[] EMPTY_ARRAY = new String[0];
    private static final char STARTING_WITH = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            if (value == -1) {
                return EMPTY_ARRAY;
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder builder = new StringBuilder();
            for (String word : words) {
                if (word.charAt(0) == STARTING_WITH) {
                    builder.append(word).append("=");
                }
            }
            result = builder.toString().split("=");
            Arrays.sort(result);
            return builder.length() == 0 ? EMPTY_ARRAY : result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + file, e);
        }
    }
}
