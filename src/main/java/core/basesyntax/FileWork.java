package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] filtered;
        int count = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }

            String[] words = stringBuilder.toString().split("\\W+");
            for (String word : words) {
                if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    count++;
                }
            }

            filtered = new String[count];
            int x = 0;

            for (String word : words) {
                if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    filtered[x++] = word.toLowerCase();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Arrays.sort(filtered);

        return filtered;
    }
}
