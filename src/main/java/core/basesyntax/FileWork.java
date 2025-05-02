package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File myFile = new File(fileName);

        try (BufferedReader bufferedWriter = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = bufferedWriter.readLine()) != null) {
                stringBuilder.append(line.toLowerCase()).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't run this file", e);
        }

        String[] splitArray = stringBuilder.toString().split("\\W+");

        int count = 0;
        for (String word : splitArray) {
            if (word.startsWith("w")) {
                count++;
            }
        }

        if (count == 0) {
            return new String[0];
        }

        String[] sortedArray = new String[count];
        int index = 0;
        for (int i = 0; i < splitArray.length; i++) {
            if (splitArray[i].startsWith("w")) {
                sortedArray[index++] = splitArray[i];
            }
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
