package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String specialChar = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        String needWords = "";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("can`t read", e);
        }

        String allText = builder.toString().toLowerCase();
        String[] splitedValue = allText.split("\\W+");
        for (String words : splitedValue) {
            if (words.startsWith(specialChar)) {
                needWords += words + " ";
                count++;
            }
        }
        String[] result = new String[count];
        String[] splitedNeedsValue = needWords.split(" ");
        for (int i = 0; i < result.length; i++) {
            result[i] = splitedNeedsValue[i];
        }
        Arrays.sort(result);

        return result;
    }
}
