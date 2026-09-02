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
                return new String[]{};
            }
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] line = builder.toString().toLowerCase().split("\\W+");
            Arrays.sort(line);
            StringBuilder result = new StringBuilder();
            for (String ln : line) {
                if (ln.charAt(0) == 'w') {
                    result.append(ln).append(" ");
                }
            }
            String[] resultArray = result.toString().split(" ");
            if (resultArray.length == 1) {
                return new String[]{};
            }
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
    }
}
