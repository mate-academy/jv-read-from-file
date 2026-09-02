package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        StringBuilder recordString = new StringBuilder();
        String[] resultArr = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value;
            while ((value = reader.readLine()) != null) {
                recordString.append(value).append(System.lineSeparator());
            }
            String[] fileNameSplit = recordString.toString().split("\\W+");
            int count = 0;

            for (String word : fileNameSplit) {
                if (!word.isEmpty() && (word.toLowerCase().charAt(0) == 'w')) {
                    count++;
                }
            }

            resultArr = new String[count];
            int currentIndex = 0;

            for (String word : fileNameSplit) {
                if (!word.isEmpty() && (word.toLowerCase().charAt(0) == 'w')) {
                    resultArr[currentIndex] = word.toLowerCase();
                    currentIndex++;
                }
            }
            Arrays.sort(resultArr);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return resultArr;
    }
}
