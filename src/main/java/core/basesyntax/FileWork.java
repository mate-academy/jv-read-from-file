package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            } else {
                while (value != null) {
                    stringBuilder.append(value).append(" ");
                    value = bufferedReader.readLine();
                }
                String lineFromFile = stringBuilder.toString();
                String[] split = lineFromFile.split("\\W+");
                String[] tempArray = new String[split.length];
                int index = 0;
                for (String word: split) {
                    if (word.toLowerCase().charAt(0) == SPECIFIED_CHARACTER) {
                        tempArray[index] = word.toLowerCase();
                        index++;
                    }
                }
                String[] resultArray = Arrays.copyOf(tempArray, index);
                Arrays.sort(resultArray);
                return resultArray;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open file");
        }
    }
}
