package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String patternSymbol = "w";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from current file", e);
        }

        String[] wordsArray = stringBuilder.toString().split("\\W+");

        stringBuilder.setLength(0);

        for (String word : wordsArray) {
            if (word.toLowerCase().startsWith(patternSymbol)) {
                stringBuilder.append(word.toLowerCase()).append(" ");
            }
        }

        if (stringBuilder.isEmpty()) {
            return new String[0];
        }

        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);

        return result;
    }
}
