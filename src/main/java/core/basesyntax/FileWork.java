package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        char[] array = new char[999999];
        String[] result = new String[1];
        try {
            FileReader input = new FileReader(fileName);
            input.read(array);
            String str1 = new String(array);
            String[] str = str1.split("\\W+");
            int count = 0;
            for (String s : str) {
                if (s.startsWith("w") || s.startsWith("W")) {
                    count++;
                }
            }
            result = new String[count];
            int index = 0;
            for (String s : str) {
                if (s.startsWith("w") || s.startsWith("W")) {
                    result[index] = s.toLowerCase();
                    index++;
                }
            }
            Arrays.sort(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
