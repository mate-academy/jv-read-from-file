package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final int FIRST_WOLD_SYMBOL = 0;
    private static final String SPLIT_SYMBOL = " ";
    private static final char CHECK_SYMBOL = 'w';

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value;

            while ((value = bufferedReader.readLine()) != null) {
                String[] line = value.split("\\W+");
                for (String word : line) {
                    word = word.toLowerCase();
                    if (word.charAt(FIRST_WOLD_SYMBOL) == CHECK_SYMBOL) {
                        stringBuilder.append(word).append(SPLIT_SYMBOL);
                    }
                }
            }
            String finalText = stringBuilder.toString();
            if (finalText.length() != 0) {
                String[] test = finalText.split(SPLIT_SYMBOL);
                Arrays.sort(test);
                return test;
            } else {
                return new String[0];
            }
        } catch (Exception e) {
            throw new RuntimeException("File is absent");
        }
    }
}
