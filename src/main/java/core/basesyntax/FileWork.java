package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String START_CHAR = "w";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            int charCode = bufferedReader.read();
            while (charCode != -1) {
                stringBuilder.append((char) charCode);
                charCode = bufferedReader.read();

            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file");
        }
        String[] wordsFromFile = stringBuilder.toString().toLowerCase().split("\\W+");
        stringBuilder.delete(0, stringBuilder.length());
        for (int i = 0; i < wordsFromFile.length; i++) {
            if (wordsFromFile[i].startsWith(START_CHAR)) {
                stringBuilder.append(wordsFromFile[i]).append(SPACE);
            }
        }
        String[] res = null;
        if (stringBuilder.length() != 0) {
            res = stringBuilder.toString().split(SPACE);
            Arrays.sort(res);
        } else {
            return new String[0];
        }

        return res;
    }
}
