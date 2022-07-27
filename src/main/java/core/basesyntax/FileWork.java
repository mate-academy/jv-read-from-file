package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] notRefactoredData = read(fileName);
        return deleteAndSort(notRefactoredData);
    }
    
    public static String[] deleteAndSort(String[] notRefactoredArray) {
        StringBuilder refactoredData = new StringBuilder();
        for (String value: notRefactoredArray) {
            value = value.toLowerCase();
            if (value.startsWith("w")) {
                refactoredData.append(value).append(" ");
            }
        }
        if (refactoredData.length() == 0) {
          return new String[]{};
        }
        String[] result = refactoredData.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
    
    public static String[] read(String fileName) {
        try {
            File file = new File("" + fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder notRefactoredData = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
              return new String[]{};
            }
            while (value != null) {
                notRefactoredData.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            return notRefactoredData.toString().split("\\W+");
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
