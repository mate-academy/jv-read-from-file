package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private StringBuilder builder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("I can`t find file", e);
        }
        String [] arrays = builder.toString().toLowerCase().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String str = new String();
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        for (String array : arrays) {
            if (array.charAt(0) == 'w') {
                str = array;
                str = str.replace(",", "");
                str = str.replace(".", "");
                str = str.replace("?", "");
                str = str.replace("!", "");
                str = str.replace(System.lineSeparator(), " ");
                stringBuilder.append(str).append(" ");
            }
        }
        if (str.isEmpty()) {
            return new String[0];
        }
        String[] strArrays = stringBuilder.toString().split(" ");
        Arrays.sort(strArrays);
        return strArrays;
    }
}
