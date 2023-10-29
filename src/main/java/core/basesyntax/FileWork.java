package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        char[] array = new char[500];
        FileReader fileReader = null;
        int counter = 0;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read the file.");
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            bufferedReader.read(array);
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file.");
        }
        String stringResult = String.valueOf(array).toLowerCase();
        String[] arrayResult = stringResult.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arrayResult.length; i++) {
            if (startWithW(arrayResult[i])) {
                stringBuilder.append(arrayResult[i])
                        .append(" ");
                counter++;
            }
        }
        arrayResult = stringBuilder.toString().split(" ");
        Arrays.sort(arrayResult);
        if (counter == 0) {
            return new String[0];
        }
        return arrayResult;
    }

    public boolean startWithW(String word) {
        return word.charAt(0) == 'w';
    }
}
