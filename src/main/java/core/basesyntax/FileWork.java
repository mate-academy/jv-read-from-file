package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                String[] nullArray = new String[]{};
                return nullArray;
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found!");
        }

        String[] split = stringBuilder.toString().split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String word : split) {
            if (word.substring(0,1).equals("w")) {
                builder.append(word).append(" ");
            } else if (word.substring(0,1).equals("W")) {
                builder.append(word.toLowerCase()).append(" ");
            }
        }
        String[] arrayW = builder.toString().split(" ");
        Arrays.sort(arrayW);
        return arrayW;
    }

}
