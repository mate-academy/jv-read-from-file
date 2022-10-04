package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        String[] split = stringBuilder.toString().split("\\W+");
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String string :
                split) {
            if (Character.toLowerCase(string.charAt(0)) == 'w') {
                builder.append(string).append(SPACE);
                i++;
            }
        }
        if (i == 0) {
            return new String[]{};
        }
        String[] result = builder.toString().toLowerCase().split(SPACE);
        Arrays.sort(result);
        return result;
    }
}
