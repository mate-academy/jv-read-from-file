package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result = new String[0];
        if (new File(fileName).length() == 0) {
            return result;
        }
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            int value = fileReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = fileReader.read();
            }
            String[] words = stringBuilder.toString().toLowerCase().split("([?!.])* |\\.|\n");
            stringBuilder = new StringBuilder();
            for (String word : words) {
                if (word.matches("w.*")) {
                    stringBuilder.append(word).append(" ");
                }
            }
            if (!stringBuilder.toString().equals("")) {
                result = stringBuilder.toString().split(" ");
                List<String> forSorting = Arrays.asList(result);
                Collections.sort(forSorting);
                result = forSorting.toArray(new String[0]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
