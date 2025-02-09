package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String result = null;
        String value = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            value = bufferedReader.readLine();

            if (value == null) {
                return new String[0];
            }

            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }

            result = stringBuilder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("There is no such file" + e);
        }

        String[] splitText = result.split("\\W+");
        String[] resultArray = new String[splitText.length];
        int count = 0;

        for (String word: splitText) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                resultArray[count] = word;
                count++;
            }
        }

        String[] sortedArray = new String[count];
        int secondCount = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] != null) {
                sortedArray[secondCount] = resultArray[i];
                secondCount++;
            }
        }

        Arrays.sort(sortedArray);

        return sortedArray;
    }
}
