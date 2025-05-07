package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private StringBuilder builder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] allWordsArray = builder.toString().toLowerCase().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String result = new String();
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        for (String word: allWordsArray) {
            if (word.charAt(0) == 'w') {
                result = word;
                result = result.replace(".", "");
                result = result.replace(",", "");
                result = result.replace("!", "");
                result = result.replace("?", "");
                result = result.replace(System.lineSeparator(), " ");
                stringBuilder.append(result).append(" ");
            }
        }
        if (result.isEmpty()) {
            return new String[0];
        }
        String[] resultArray = stringBuilder.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
