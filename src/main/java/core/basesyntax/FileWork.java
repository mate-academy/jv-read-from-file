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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                String str = builder.append(value).toString().toLowerCase();
                String strr = Arrays.toString(str.split("w"));
                String [] split = strr.split("\\W+");
            }
        } catch (IOException e) {
            throw new RuntimeException("File not read", e);
        }
        return new String[0];
    }
}

