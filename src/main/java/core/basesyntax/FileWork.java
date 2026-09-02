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
            StringBuilder fileString = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                fileString.append((char) value);
                value = bufferedReader.read();
            }
            String[] fileStringArr = fileString.toString().toLowerCase().split("\\W+");
            int countResultSize = 0;
            for (String s : fileStringArr) {
                if (s.length() != 0 && s.charAt(0) == 'w') {
                    countResultSize++;
                }
            }
            String[] result = new String[countResultSize];
            int countIndex = 0;
            for (String s : fileStringArr) {
                if (s.length() != 0 && s.charAt(0) == 'w') {
                    result[countIndex] = s;
                    countIndex++;
                }
            }
            System.out.println(Arrays.toString(result));
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
