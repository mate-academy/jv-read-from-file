package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final Character BEGIN_SYMBOL = 'w';

    public String[] readFromFile(String fileName) {
        FileReader file = null;
        StringBuilder allString = new StringBuilder();
        ArrayList<String> rightList = new ArrayList<>();
        try {
            file = new FileReader(fileName);
            BufferedReader inputData = new BufferedReader(file);
            int value = inputData.read();
            while (value != -1) {
                allString.append((char) value);
                value = inputData.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
        String[] allResultArray = allString.toString().toLowerCase().split("\\W+");
        for (String itemString : allResultArray) {
            if (itemString.length() > 1 && itemString.charAt(0) == BEGIN_SYMBOL) {
                rightList.add(itemString);
            }
        }
        String[] resultArray = rightList.toArray(new String[rightList.size()]);
        Arrays.sort(resultArray);
        return resultArray;
    }
}

