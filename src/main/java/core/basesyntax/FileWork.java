package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String text = reader.readLine();
            if (text == null) {
                return new String[] {};
            }
            while (text != null) {
                stringBuilder.append(text).append(System.lineSeparator());
                text = reader.readLine();
            }
            String wholeText = stringBuilder.toString();
            String lowwerText = wholeText.toLowerCase();
            String[] textArray = lowwerText.split("\\W+");
            Arrays.sort(textArray);
            int count = 0;
            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i].charAt(0) == 'w') {
                    count++;
                }
            }
            String[] result = new String[count];
            int resIndex = 0;
            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i].charAt(0) == 'w') {
                    result[resIndex] = textArray[i];
                    resIndex++;
                }
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
