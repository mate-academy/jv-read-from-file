package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] words = stringBuilder.toString().split("\\W+");
            stringBuilder = new StringBuilder();
            boolean resultIsEmpty = true;
            for (String word : words) {
                word = word.toLowerCase();
                if (word != "" && word.toCharArray()[0] == 'w') {
                    stringBuilder.append(word).append(" ");
                    resultIsEmpty = false;
                }
            }
            if (resultIsEmpty) {
                return new String[0];
            }
            String[] result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file ",e);
        }
    }
}
