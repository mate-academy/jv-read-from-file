package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                String[] splitedValue = value.replaceAll("[^a-zA-Z ]", "")
                        .toLowerCase().split("\\s+");
                for (String word : splitedValue) {
                    if (startWithLetter(word)) {
                        stringBuilder.append(word)
                                .append(System.lineSeparator());
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split("\\s+");
        Arrays.sort(result);
        return result;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
