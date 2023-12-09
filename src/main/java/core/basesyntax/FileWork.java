package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        BufferedReader bufferedReader;
        StringBuilder stringBuilder;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file");
        }
        if (stringBuilder.isEmpty()) {
            return new String[0];
        } else {
            String[] readFromFile = stringBuilder.toString().toLowerCase().replace('!', ' ')
                    .replace('?', ' ')
                    .replace(',', ' ')
                    .replace('.', ' ')
                    .replaceAll("\n", " ")
                    .trim()
                    .split(" ");
            String withOutChars = new String();
            for (int i = 0; i < readFromFile.length; i++) {
                if (!readFromFile[i].isEmpty() && readFromFile[i].charAt(0) == 'w') {
                    withOutChars += readFromFile[i] + ' ';
                }
            }
            readFromFile = withOutChars.split(" ");
            Arrays.sort(readFromFile);
            if (readFromFile.length == 1) {
                return new String[0];
            }
            return readFromFile;
        }
    }
}
