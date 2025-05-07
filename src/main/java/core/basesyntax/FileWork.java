package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] array;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String str = bufferedReader.readLine();
            if (str == null || str.length() == 0) {
                return new String[0];
            }
            while (str != null) {
                String strLower = str.toLowerCase();
                String[] strSplit = strLower.split("\\W+");
                for (String element : strSplit) {
                    if (element.charAt(0) == 'w') {
                        builder.append(element).append(" ");
                    }
                }
                str = bufferedReader.readLine();
            }
            array = builder.toString().split(" ");
            Arrays.sort(array);
            if (array.length == 1) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return array;
    }
}
