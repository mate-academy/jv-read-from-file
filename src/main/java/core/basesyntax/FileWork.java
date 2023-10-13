package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATOR_OF_WORDS = " ";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            StringBuilder builder = new StringBuilder();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            String[] words = builder.toString().toLowerCase().split("\\W+");
            StringBuilder resultBuilder = new StringBuilder();
            for (String word : words) {
                if (word.charAt(0) == 'w') {
                    resultBuilder.append(word).append(SEPARATOR_OF_WORDS);
                }
            }
            if (resultBuilder.toString().isEmpty()) {
                return new String[0];
            }
            String[] appropriateWords = resultBuilder.toString().trim().split(SEPARATOR_OF_WORDS);
            Arrays.sort(appropriateWords);
            return appropriateWords;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + e);
        } catch (StringIndexOutOfBoundsException e) {
            return new String[0];
        }
    }
}
