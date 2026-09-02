package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final char INITIAL_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try {
            builder.append(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        String[] convert = builder.toString().toLowerCase().split("\\W+");
        for (String str : convert) {
            if (str.length() > 0 && str.charAt(0) == 'w') {
                count++;
            }
        }
        String[] resultArray = new String[count];
        int k = 0;
        for (String s : convert) {
            if (s.length() > 0 && s.charAt(0) == INITIAL_LETTER) {
                resultArray[k] = s;
                k++;
            }
        }
        Arrays.sort(resultArray);
        return resultArray;
    }
}
