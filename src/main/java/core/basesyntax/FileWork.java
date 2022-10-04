package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPLIT_STRING = "\\W+";
    private static final String DELIMITER = ";";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                String[] split = value.split(SPLIT_STRING);
                for (String word:split){
                    word = word.toLowerCase();
                    if (word.charAt(0) == 'w') {
                        stringBuilder.append(word).append(DELIMITER);
                    }
                }
                value = reader.readLine();
            }
            if (stringBuilder.length() == 0) {
                return new String[0];
            }
            String[] result = stringBuilder.toString().split(DELIMITER);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't open file: ", e);
        }
    }
}
