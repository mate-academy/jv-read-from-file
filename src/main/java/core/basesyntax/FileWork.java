package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();

            while (value != null) {
                String[] strings = value.split(" ");
                for (String str : strings) {
                    String st = str.toLowerCase().replaceAll("[!?.]","");
                    if (st.startsWith("w")) {
                        stringBuilder.append(st).append(" ");
                    }
                }

                String ff = stringBuilder.toString();
                value = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file",e);
        }
        if (!stringBuilder.isEmpty()) {
            String[] str = stringBuilder.toString().split(" ");
            Arrays.sort(str);
            return str;
        } else {
            return new String[0];
        }
    }
}
