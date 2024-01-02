package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String result = "";
        try {
            result = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file");
        }

        String[] fromFile = result.split("\\W+");
        int length = 0;
        for (int i = 0; i < fromFile.length; i++) {
            if (fromFile[i].toLowerCase().startsWith("w")) {
                length++;
            }
        }

        int index = 0;
        String[] resultArray = new String[length];
        for (int i = 0; i < fromFile.length; i++) {
            if (fromFile[i].toLowerCase().startsWith("w")) {
                resultArray[index] = fromFile[i].toLowerCase();
                index++;
            }
        }

        Arrays.sort(resultArray);

        return resultArray;
    }
}
