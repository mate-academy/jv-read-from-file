package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] emptyArr = new String[0];
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int letter = bufferedReader.read();
            while (letter != -1) {
                stringBuilder.append((char) letter);
                letter = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringBuilder.length() == 0) {
            return emptyArr;
        }
        String[] allTextFromFile = stringBuilder.toString().split("\\W+");
        StringBuilder onlyWwWordsBuilder = new StringBuilder();
        if (onlyWwWordsBuilder == null) {
            return null;
        }
        for (int i = 0; i < allTextFromFile.length; i++) {
            if (allTextFromFile[i].charAt(0) == 119 || allTextFromFile[i].charAt(0) == 87) {
                onlyWwWordsBuilder.append(allTextFromFile[i].toLowerCase()).append(" ");
            }
        }
        if (onlyWwWordsBuilder.length() == 0) {
            return emptyArr;
        }
        String[] strArray = onlyWwWordsBuilder.toString().split(" ");
        Arrays.sort(strArray);
        return strArray;
    }
}
