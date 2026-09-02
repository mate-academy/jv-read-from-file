package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FILTER_LETTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            int value = reader.read();

            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }

            String fileContent = builder.toString();
            String[] separateContent = fileContent.split("[^a-zA-Z]+");

            int resultArrayLength = 0;
            for (String word: separateContent) {
                if (word.toLowerCase().startsWith(FILTER_LETTER)) {
                    resultArrayLength++;
                }
            }

            String[] resultArray = new String[resultArrayLength];
            int resultArrayIndex = 0;
            for (int i = 0; i < separateContent.length; i++) {
                if (separateContent[i].toLowerCase().startsWith(FILTER_LETTER)) {
                    resultArray[resultArrayIndex] = separateContent[i].toLowerCase();
                    resultArrayIndex++;
                }
            }

            Arrays.sort(resultArray);

            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
