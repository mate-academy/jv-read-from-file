package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String text = reader.readLine();
            int counter = 0;
            int resultIndex = 0;

            if (text == null) {
                return new String[0];
            }

            while (text != null) {
                builder.append(text).append(System.lineSeparator());
                text = reader.readLine();
            }
            String allLineText = builder.toString();
            String[] allLineTextArray = allLineText.toLowerCase().split("\\W+");
            Arrays.sort(allLineTextArray);

            for (int i = 0; i < allLineTextArray.length; i++) {
                if (allLineTextArray[i].charAt(0) == 'w') {
                    counter++;
                }
            }
            String[] results = new String[counter];

            for (int i = 0; i < allLineTextArray.length; i++) {
                if (allLineTextArray[i].charAt(0) == 'w') {
                    results[resultIndex] = allLineTextArray[i];
                    resultIndex++;
                }
            }
            return results;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
