package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file.", e);
        }
        String[] filteredFile = stringBuilder.toString().toLowerCase().split("\\W+");
        Arrays.sort(filteredFile);
        StringBuilder result = new StringBuilder();
        for (String i : filteredFile) {
            if (i.charAt(0) == 'w') {
                result.append(i).append(' ');
            }
        }
        if (result.length() == 0) {
            return new String[0];
        }
        return result.toString().split(" ");
    }
}
