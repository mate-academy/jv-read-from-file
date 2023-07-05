package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char W_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder resultString = new StringBuilder();
        String[] resultArray;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();

            while (value != null) {
                String[] currentValueArray = value.split(" ");

                for (int i = 0; i < currentValueArray.length; ++i) {
                    String currentValueString = currentValueArray[i].toLowerCase();
                    if (currentValueString.charAt(0) == W_CHAR) {
                        if (resultString.length() >= 1) {
                            resultString.append(" ");
                        }
                        resultString.append(cleanWord(currentValueString));
                    }
                }
                value = reader.readLine();
            }

            if (resultString.length() < 1) {
                return new String[0];
            }
            resultArray = resultString.toString().split(" ");
            Arrays.sort(resultArray);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return resultArray;
    }

    public String cleanWord(String word) {
        return word.replaceAll("[\\p{Punct}]", "");
    }
}
