package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final String TARGET_LETTER = "w";

    public String[] readFromFile(String fileName) {

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }

            String[] split = stringBuilder.toString().toLowerCase().split("[^a-zA-Z]+");

            int count = 0;
            for (String word : split) {
                if (!word.isEmpty() && word.startsWith(TARGET_LETTER)) {
                    count++;
                }
            }
            if (count == 0) {
                return new String[0];
            }
            String[] result = new String[count];
            int index = 0;
            for (String word : split) {
                if (!word.isEmpty() && word.startsWith(TARGET_LETTER)) {
                    result [index++] = word;
                }
            }

            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            throw new RuntimeException("Unable to read file" + fileName, e);
        }
    }
}
