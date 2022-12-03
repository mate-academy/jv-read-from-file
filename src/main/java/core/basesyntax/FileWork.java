package core.basesyntax;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] array = stringBuilder.toString().toLowerCase().split("\\W+");
            stringBuilder.setLength(0);
            for (String word: array) {
                if (word.charAt(0) == 'w') {
                    stringBuilder.append(word).append(" ");
                }
            }
            if (stringBuilder.length() != 0) {
                String[] words = stringBuilder.toString().split(" ");
                Arrays.sort(words);
                return words;
            }
            return new String[]{};
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
