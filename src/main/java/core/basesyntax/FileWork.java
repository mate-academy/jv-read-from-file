package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }

        String text;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder readerBuilder = new StringBuilder();
            int charNum = reader.read();
            while (charNum != -1) {
                readerBuilder.append((char) charNum);
                charNum = reader.read();
            }
            text = readerBuilder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] splittedText = text.split("\\W+");
        StringBuilder newStr = new StringBuilder();
        for (String wordW : splittedText) {
            if (wordW.charAt(0) == 'w') {
                newStr.append(wordW).append(System.lineSeparator());
            }
        }
        String strW = newStr.toString();
        String[] arrW = strW.split(System.lineSeparator());
        Arrays.sort(arrW);
        if (arrW[0].equals("")) {
            return new String[0];
        }
        return arrW;
    }
}
