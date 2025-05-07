package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here

        final int arrSize = 100;
        final char symbol = (char) 39;

        File file = new File(fileName);
        String[] subResult = new String[arrSize];
        StringBuilder string = new StringBuilder();
        int wordCounter = 0;

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(file));
            String value = buffReader.readLine();
            String[] lines = new String[arrSize];

            while (value != null) {
                lines = value.split(" ");
                for (String checker : lines) {
                    // char[] charArr = .toCharArray();
                    if (checker.charAt(0) == 'w' || checker.charAt(0) == 'W') {
                        for (int i = 0; i < checker.length(); i++) {
                            if (checker.charAt(i) != '.' & checker.charAt(i) != ','
                                    & checker.charAt(i) != '!' & checker.charAt(i) != '?'
                                    & checker.charAt(i) != symbol & checker.charAt(i) != ':'
                                    & checker.charAt(i) != ';') {
                                string.append(checker.charAt(i));
                            }
                        }
                        subResult[wordCounter] = string.toString().toLowerCase();
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

        String[] result = new String[wordCounter];
        for (int i = 0; i < wordCounter; i++) {
            result[i] = subResult[i];
        }

        Arrays.sort(result);

        return result;
    }
}
