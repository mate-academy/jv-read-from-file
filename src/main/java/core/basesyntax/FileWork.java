package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] returnValue = new String[0];
        File file = new File(fileName);
        StringBuilder readerForWords = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilderForFile = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilderForFile.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] workList = stringBuilderForFile.toString().split("\\s+");
            for (int i = 0; i < workList.length; i++) {
                if (workList[i].toLowerCase().startsWith("w")) {
                    readerForWords.append(workList[i].toLowerCase()
                            .replaceAll("\\W", "")).append(" ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file.", e);
        }
        if (readerForWords.toString().isEmpty()) {
            returnValue = new String[0];
        } else if (!readerForWords.toString().isEmpty()) {
            returnValue = readerForWords.toString().split("\\s+");
            Arrays.sort(returnValue);
        }
        return returnValue;
    }
}
