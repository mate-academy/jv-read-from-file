package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String str;
        String [] strings;

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            str = bufferedReader.readLine();
            while (str != null) {
                sb.append(str).append(" ");
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        if (sb.toString().isEmpty()) {
            return new String[0];
        }
        strings = sb.toString().toLowerCase().split("\\W+");
        sb.delete(0,sb.length());
        for (String string : strings) {
            if (string.charAt(0) == 'w') {
                sb.append(string).append(" ");
            }
        }

        if (sb.toString().isEmpty()) {
            return new String[0];
        }
        String [] wordsWithW = sb.toString().split(" ");
        Arrays.sort(wordsWithW);
        return wordsWithW;
    }
}
