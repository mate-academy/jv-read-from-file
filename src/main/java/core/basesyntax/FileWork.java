package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        final String findString = "w";
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int oneCharFromFile = bufferedReader.read();
            if (oneCharFromFile == -1) {
                return new String[0];
            }
            while (oneCharFromFile != -1) {
                stringBuilder.append((char) oneCharFromFile);
                oneCharFromFile = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file.", e);
        }
        String myString = stringBuilder.toString();
        myString = myString.replaceAll("[\\W]", " ");
        myString = myString.replaceAll("  ", " ");
        myString = myString.toLowerCase();
        String[] words = myString.split(" ");

        int i = 0;
        for (String index: words) {

            if (findString.equals(String.valueOf(index.charAt(0)))) {
                i++;
            }
        }
        String [] resultArray = new String[i];
        i = 0;
        for (String index: words) {
            if (findString.equals(String.valueOf(index.charAt(0)))) {
                resultArray[i] = index;
                i++;
            }
        }
        Arrays.sort(resultArray);
        return resultArray;
    }
}
