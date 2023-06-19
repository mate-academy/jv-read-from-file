package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        int count = 0;
        String[] result = new String[count];
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                String[] splitFile = value.toLowerCase().split("\\W+");
                for (String i : splitFile) {
                    if (i.charAt(0) == SPECIFIED_CHARACTER) {
                        count++;
                    }
                }
                int temp = 0;
                for (String i : splitFile) {
                    if (i.charAt(0) == SPECIFIED_CHARACTER) {
                        result[temp] = i;
                        temp++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't find" + fileName + e);
        }
        Arrays.sort(result);
        return result;
    }
}
