package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String inputString = stringBuilder.toString().toLowerCase();
            String[] arrayOfStrings = inputString.split("\\W+");
            if (arrayOfStrings.length == 0 || arrayOfStrings.length == 1) {
                return new String[]{};
            }
            StringBuilder stringBuilder1 = new StringBuilder();
            for (String string : arrayOfStrings) {
                if (string.startsWith("w")) {
                    stringBuilder1.append(string).append(" ");
                }
            }
            if (stringBuilder1.length() == 0) {
                return new String[]{};
            }
            String inputString1 = stringBuilder1.toString();
            String[] arrayOfStrings1 = inputString1.split(" ");
            Arrays.sort(arrayOfStrings1);
            return arrayOfStrings1;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file",e);
        }
    }
}
