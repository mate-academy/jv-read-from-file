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
            String value = reader.readLine();
            if (value == null) {
                return new String[] {};
            }
            int wordCount = 0;
            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(System.lineSeparator());
                String [] words = value.split(" ");
                for (String word: words) {
                    if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                        wordCount++;
                    }
                }
                value = reader.readLine();
            }
            String text = stringBuilder.toString();
            String[] textArray = text.split("\\W+");
            Arrays.sort(textArray);
            String [] result = new String[wordCount];

            int resIndex = 0;
            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i].charAt(0) == 'w') {
                    result[resIndex] = textArray[i];
                    resIndex++;
                }
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
