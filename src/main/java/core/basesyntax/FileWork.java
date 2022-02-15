package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String LETTER_W = "w";
    public static final String COMA = ",";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                String[] parts = value.toLowerCase().split("\\W+");
                for (String word : parts) {
                    if (word.startsWith(LETTER_W)) {
                        stringBuilder.append(word.toLowerCase()).append(COMA);
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        }
        String[] output = stringBuilder.toString().split(COMA);
        Arrays.sort(output);
        return output;
    }
}

