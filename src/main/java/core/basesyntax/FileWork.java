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
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                stringBuilder.append(readLine).append(' ');
                readLine = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder resultBuilder = new StringBuilder();
            if (stringBuilder.toString().length() == 0) {
                return new String[0];
            }
            for (String word : words) {
                if (word.charAt(0) == 'w') {
                    resultBuilder.append(word).append(" ");
                }
            }
            if (resultBuilder.toString().length() == 0) {
                return new String[0];
            }
            String[] result = resultBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
