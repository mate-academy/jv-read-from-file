package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String string = bufferedReader.readLine();
            if (string == null || string.length() == 0) {
                return new String[0];
            }
            while (string != null) {
                String toLower = string.toLowerCase();
                String[] splited = toLower.split("\\W+");
                for (String word : splited) {
                    if (word.charAt(0) == 'w') {
                        builder.append(word).append(" ");
                    }
                }
                string = bufferedReader.readLine();
            }
            result = builder.toString().split(" ");
            Arrays.sort(result);
            if (result.length == 1) {
                return new String[0];
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
        return result;
    }
}
