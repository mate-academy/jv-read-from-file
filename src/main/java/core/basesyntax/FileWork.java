package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + e);
        }
        try {
            String originalString = "";
            while (originalString != null) {
                originalString = reader.readLine();
                stringBuilder.append(originalString).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + e);
        }
        int counter = 0;
        String[] splited = stringBuilder.toString().split("\\W+");
        StringBuilder resultString = new StringBuilder();
        for (String split : splited) {
            if (split.charAt(0) == 'W' || split.charAt(0) == 'w') {
                resultString.append(split).append(" ");
                counter++;
            }
        }
        String result = resultString.toString().toLowerCase();
        String[] resultArray = result.split(" ");
        if (counter != 0) {
            Arrays.sort(resultArray);
            return resultArray;
        }
        return new String[]{};
    }
}
