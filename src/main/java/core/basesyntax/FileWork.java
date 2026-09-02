package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        String[] result = {};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return result;
            }
            while (value != null) {
                String sentence = value.toLowerCase();
                String[] split = sentence.split("\\W+");
                for (String words: split) {
                    if (words.charAt(0) == 'w') {
                        builder.append(words).append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
            result = builder.toString().split(" ");
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("File doesn`t exist", e);
        }
        if (result.length == 1) {
            return new String[0];
        }
        return result;
    }
}
