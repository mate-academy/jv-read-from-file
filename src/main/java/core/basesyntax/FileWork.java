package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String value = " ";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String line = stringBuilder.toString().toLowerCase();
        String[] firstArray = line.split("\\W");
        int countWWords = 0;
        for (String name : firstArray) {
            if (name.startsWith("w")) {
                countWWords++;
            }
        }
        String[] resultArray = new String[countWWords];
        int posCaunt = 0;
        for (String name : firstArray) {
            if (name.startsWith("w")) {
                resultArray[posCaunt] = name;
                posCaunt++;
            }
        }
        Arrays.sort(resultArray);
        for (String name : resultArray) {
        }
        return resultArray;
    }
}
