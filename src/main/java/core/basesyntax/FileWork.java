package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int INDEX = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String[] stringArray;
        String[] resultStringArray;
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = reader.readLine();
            if (str == null) {
                resultStringArray = new String[0];
                return resultStringArray;
            }
            while (str != null) {
                builder.append(str);
                builder.append("\n");
                str = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        stringArray = builder.toString().toLowerCase().split("\\W+");
        for (String str : stringArray) {
            if (str.charAt(INDEX) == 'w') {
                count++;
            }
        }
        resultStringArray = new String[count];
        int i = 0;
        for (String str : stringArray) {
            if (str.charAt(INDEX) == 'w') {
                resultStringArray[i] = str;
                i++;
            }
        }
        Arrays.sort(resultStringArray);
        return resultStringArray;
    }
}
