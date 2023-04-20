package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();

            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value);
                value = reader.readLine();
            }
            String test2Readered = stringBuilder.toString();
            String[] test2Array = test2Readered.split(" ");
            int wordStartWithLetterWLength = 0;
            String[] wordStartWithLetterW = new String[wordStartWithLetterWLength];
            for (int i = 0; i < test2Array.length; i++) {
                if (test2Array[i] == "w") {
                    test2Array[i] = wordStartWithLetterW[i];
                    wordStartWithLetterWLength++;
                }
            }
            String[] reverseWord = new String[wordStartWithLetterWLength];
            for (int i = test2Array.length - 1; i < test2Array.length; i--) {
                test2Array[i] = reverseWord[i];
            }
            return reverseWord;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
