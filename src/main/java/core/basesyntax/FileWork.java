package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String text = reader.readLine();

            while (text != null) {
                text = text.toLowerCase();
                String[] textArray = text.split("\\W+");
                for (String word : textArray) {
                    if (word.charAt(0) == 'w') {
                        builder.append(word).append(" ");
                    }
                }
                text = reader.readLine();
            }

            if (builder.length() == 0) {
                return new String[] {};
            }

            String[] result = builder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
