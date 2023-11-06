package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIC = "w";

    public String[] readFromFile(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (word.startsWith(SPECIFIC)) {
                builder.append(word).append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[]{};
        }
        String[] result = builder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
