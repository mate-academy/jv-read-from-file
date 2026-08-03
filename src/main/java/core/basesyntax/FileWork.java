package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String string = new String();
        File file = new File(fileName);
        StringBuilder builderReader = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            while (value != -1) {
                builderReader.append((char) value);
                value = bufferedReader.read();
            }
            string = builderReader.toString();
        } catch (IOException e) {
            throw new RuntimeException("Exception during reading", e);
        }
        char[] charArray = string.toCharArray();
        if (charArray == null || charArray.length == 0) {
            return new String[0];
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (((int) charArray[i] >= 65 && (int) charArray[i] <= 90)
                        || ((int) charArray[i] >= 97 && (int) charArray[i] <= 122)) {
                builder.append(charArray[i]);
            } else if ((i > 0) && (((int) charArray[i] < 65 || (int)charArray[i] > 122)
                    || ((int) charArray[i] > 90 && (int) charArray[i] < 97))
                    && (((int) charArray[i - 1] >= 65 && (int) charArray[i - 1] <= 90)
                    || ((int) charArray[i - 1] >= 97 && (int) charArray[i - 1] <= 122))) {
                builder.append(" ");
            }
        }
        String[] stringArray = builder.toString().toLowerCase().split(" ");
        StringBuilder secondBuilder = new StringBuilder();
        for (String s : stringArray) {
            if (s.length() != 0 && s.charAt(0) == 'w') {
                secondBuilder.append(s).append(" ");
            }
        }
        if (secondBuilder.toString().length() < 1) {
            return new String[0];
        }
        String[] result = secondBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
