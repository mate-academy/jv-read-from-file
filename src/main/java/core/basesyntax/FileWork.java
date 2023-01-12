package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                str.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }
        String[] arrayStr = str.toString().split("\\W+");
        StringBuilder resultStr = new StringBuilder();

        for (String s : arrayStr) {
            String word = s.toLowerCase();
            String w = "w";
            if (word.substring(0, 1).equals(w)) {
                resultStr.append(word).append(" ");
            }
        }

        if (resultStr.toString().isEmpty()) {
            return new String[0];
        }

        String[] result = resultStr.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
