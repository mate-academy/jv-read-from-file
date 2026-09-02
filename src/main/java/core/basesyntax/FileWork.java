package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            StringBuilder textFromFile = new StringBuilder();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                textFromFile.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] arrayTexts = textFromFile.toString().toLowerCase().split(" ");
            StringBuilder splitText = new StringBuilder();
            for (String arrayText : arrayTexts) {
                if (arrayText.startsWith("w")) {
                    splitText.append(arrayText).append(" ");
                }
            }
            if (splitText.isEmpty()) {
                return new String[0];
            }
            String[] result = splitText.toString().split(" ");
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i].replaceAll("[^a-z ]", "");
            }
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't found the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
