package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(' ');
                value = bufferedReader.readLine();
            }
            String[] wordsOfFile = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder resultString = new StringBuilder();
            if (stringBuilder.toString().length() == 0) {
                return new String[0];
            }
            for (String word: wordsOfFile) {
                if (word.charAt(0) == 'w') {
                    resultString.append(word).append(" ");
                }
            }
            if (resultString.toString().length() == 0) {
                return new String[0];
            }
            String[] result = resultString.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Exception", e);
        }
    }
}
