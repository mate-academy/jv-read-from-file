package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String str = reader.readLine();
            while (str != null) {
                String[] split = str.split("\\W+");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].toLowerCase().startsWith("w")) {
                        builder.append(split[i]).append(",");
                    }
                }
                str = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] result = builder.toString().toLowerCase().split(",");
        Arrays.sort(result);
        return result;
    }
}
