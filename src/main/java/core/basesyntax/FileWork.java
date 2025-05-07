package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] sortedArray = null;
        StringBuilder resultStringBuilder = new StringBuilder();
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Can't read file: " + ex.getMessage(), ex);
        }
        String[] words = stringBuilder.toString().trim().split("[\\W]+");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].toLowerCase().startsWith("w")) {
                resultStringBuilder.append(words[i].toLowerCase()).append(" ");
            }
        }
        sortedArray = resultStringBuilder.toString().trim().split(" ");
        if (sortedArray.length == 0 || (sortedArray.length == 1 && sortedArray[0].isEmpty())) {
            return new String[0];
        } else {
            Arrays.sort(sortedArray);
            return sortedArray;
        }
    }
}
