package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        String lines = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();

            if (value == -1) {
                return new String[0];
            }

            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            lines = stringBuilder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] splitedLine = lines.split("\\W+");
        StringBuilder emptyLine = new StringBuilder();
        for (int i = 0; i < splitedLine.length; i++) {
            if (splitedLine[i].indexOf("w") == 0) {
                emptyLine.append(splitedLine[i]).append(" ");
            }
        }
        if (emptyLine.length() == 0) {
            return new String[0];
        }
        String[] result = emptyLine.toString().split("\\W+");
        Arrays.sort(result);
        return result;
    }
}
