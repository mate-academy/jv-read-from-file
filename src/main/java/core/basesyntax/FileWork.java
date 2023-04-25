package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String value = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() > 1) {
            String[] readDataFromFile = stringBuilder.toString().split("\\W+");
            StringBuilder builder = new StringBuilder();
            String str = "";
            for (int i = 0; i < readDataFromFile.length; i++) {
                if ((readDataFromFile[i].startsWith("w"))
                        || (readDataFromFile[i].startsWith("W"))) {
                    str = builder.append(readDataFromFile[i]).append(" ").toString().toLowerCase();
                }
            }
            if (str.length() == 0) {
                return new String[0];
            } else {
                readDataFromFile = str.split(" ");
                Arrays.sort(readDataFromFile);
                return readDataFromFile;
            }
        } else {
            return new String[0];
        }
    }
}
