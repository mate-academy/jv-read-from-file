package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder string = new StringBuilder();
            int value = bufferedReader.read();

            if (value == -1) {
                return new String[0];
            }

            while (value != -1) {
                string.append((char)value);
                value = bufferedReader.read();
            }

            String[] splitString = string.toString().toLowerCase().split("\\W+");
            StringBuilder wordsWithW = new StringBuilder();
            for (int i = 0; i < splitString.length; i++) {
                if ('w' == splitString[i].charAt(0)) {
                    wordsWithW.append(splitString[i]).append(" ");
                }
            }
            if (wordsWithW.length() == 0) {
                return new String[0];
            }
            String[] wordsArray = wordsWithW.toString().split("\\W+");
            Arrays.sort(wordsArray);
            return wordsArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read",e);
        }
    }
}


