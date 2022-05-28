package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder readerForWords = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilderForFile = new StringBuilder();
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                stringBuilderForFile.append(value).append(" ");
            }
            String[] workList = stringBuilderForFile.toString().split("\\W+");
            for (String s : workList) {
                if (s.toLowerCase().startsWith("w")) {
                    readerForWords.append(s.toLowerCase()).append(" ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file.", e);
        }
        String[] returnValue;
        if (readerForWords.toString().isEmpty()) {
            returnValue = new String[0];
        } else {
            returnValue = readerForWords.toString().split("\\s+");
            Arrays.sort(returnValue);
        }
        return returnValue;
    }
}
