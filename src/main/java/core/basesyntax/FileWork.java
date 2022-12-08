package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here

        final int arrSize = 100;
        final char symbol = (char) 39;

        File file = new File(fileName);
        String[] result = new String[arrSize];
        StringBuilder string = new StringBuilder();
        int wordCounter = 0;

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(file));
            String value = buffReader.readLine();
            String[] lines = new String[arrSize];
            while (value != null) {
                lines = value.split(" ");
                for (String checker : lines) {
                    char[] charArr = checker.toCharArray();
                    if (charArr[0] == 'w' || charArr[0] == 'W') {
                        for (int i = 0; i < charArr.length; i++) {
                            if (charArr[i] != '.' || charArr[i] != ',' || charArr[i] != '!'
                                    || charArr[i] != '?' || charArr[i] != symbol
                                    || charArr[i] != ':' || charArr[i] != ';') {
                                string.append(charArr[i]);
                            }
                        }
                        result[wordCounter] = string.toString().toLowerCase();
                        string.setLength(0);
                        wordCounter++;
                    }
                }
                value = buffReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot open file", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
