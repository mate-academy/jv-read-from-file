package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
        Arrays.sort(words);
        for (String word : words) {
            if (word.charAt(0) == 'w') {
                resultBuilder.append(word).append(" ");
            }
        }
        if (resultBuilder.length() == 0) {
            return new String[0];
        }
        return resultBuilder.toString().split(" ");
    }
}
