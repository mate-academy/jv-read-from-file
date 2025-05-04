package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int textFromFile = reader.read();
            while (textFromFile != -1) {
                stringBuilder.append((char) textFromFile);
                textFromFile = reader.read();
            }
            String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder resultBuilder = new StringBuilder();
            for (String word : words) {
                if (word.charAt(0) == 'w') {
                    resultBuilder.append(word).append(" ");
                }
            }
            if (resultBuilder.isEmpty()) {
                return new String[0];
            }
            String[] result = resultBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        } catch (StringIndexOutOfBoundsException e) {
            return new String[0];
        }
    }
}
