package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String specialChar = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder needWords = new StringBuilder();
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("can`t read file", e);
        }

        String allText = builder.toString().toLowerCase();
        String[] needsValue = allText.split("\\W+");
        for (String words : needsValue) {
            if (words.startsWith(specialChar)) {
                needWords.append(words).append(" ");
                count++;
            }
        }
        String[] result = new String[count];
        String[] NeedsValue = needWords.toString().split(" ");
        for (int i = 0; i < result.length; i++) {
            result[i] = NeedsValue[i];
        }
        Arrays.sort(result);

        return result;
    }
}
