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
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] datas = builder.toString().toLowerCase().split("\\W+");
            StringBuilder stringBuilder = new StringBuilder();
            for (String data : datas) {
                if (data.charAt(0) == 'w') {
                    stringBuilder.append(data).append(" ");
                }
            }
            if (stringBuilder.length() == 0) {
                return new String[0];
            } else {
                String[] result = stringBuilder.toString().split("\\W+");
                Arrays.sort(result);
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file ", e);
        }
    }
}
