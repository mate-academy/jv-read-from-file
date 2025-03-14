package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            int value = bufferedReader.read();
            StringBuilder builder = new StringBuilder();
            while (value != -1) {//
                builder.append((char) (value));
                value = bufferedReader.read();
            }
            String[] result1 = {};
            String[] words = builder.toString().split("\\W+");
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : words) {
                if (word == null || word.isEmpty()) {
                    return result1;
                }

                char[] letters = word.toCharArray();
                if (letters[0] == 'w') {
                    stringBuilder.append(word).append(", ");
                }
                if (letters[0] == 'W') {

                    stringBuilder.append(word.toLowerCase()).append(", ");
                }


            }
            if(stringBuilder.isEmpty()) {return result1;}
            result = stringBuilder.toString().split(", ");

        } catch (IOException e) {
            throw new RuntimeException("Can't read to the file", e);
        }
        Arrays.sort(result);
        return result;
    }
}

