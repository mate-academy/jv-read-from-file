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
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String unsortedString = stringBuilder.toString().toLowerCase();
            if (unsortedString.isEmpty()) {
                return new String[0];
            }
            String[] sortedString = unsortedString.split("\\W+");
            StringBuilder resultString = new StringBuilder();
            for (String string : sortedString) {
                if (string.charAt(0) == 'w') {
                    resultString.append(string).append(" ");
                }
            }
            String[] finalString = resultString.toString().trim().split(" ");
            if (finalString.length == 1 && finalString[0].isEmpty()) {
                return new String[0];
            }
            Arrays.sort(finalString);
            return finalString;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
