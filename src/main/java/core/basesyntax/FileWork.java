package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                new File(fileName)))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().split("[\\s.,]+");
            stringBuilder = new StringBuilder();
            int counter = 0;
            for (String word : words) {
                if (word.length() > 0 && (word.substring(0, 1).equals(SPECIFIED_CHARACTER)
                        || word.substring(0, 1).equals(SPECIFIED_CHARACTER.toUpperCase()))) {
                    counter++;
                    stringBuilder.append(word.toLowerCase()).append(" ");
                }
            }
            if (counter == 0) {
                return new String[0];
            }
            words = stringBuilder.toString().split("[\\s!?]+");
            Arrays.sort(words);
            return words;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
