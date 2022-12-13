package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char CORRECT_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            String[] fullRead = builder.toString().toLowerCase().split("\\W+");
            builder.setLength(0);
            for (String word : fullRead) {
                if (word.charAt(0) == CORRECT_LETTER) {
                    builder.append(word).append(" ");
                }
            }
            if (builder.length() > 0) {
                String[] correctWords = builder.toString().split(" ");
                Arrays.sort(correctWords);
                return correctWords;
            }
            return new String[0];

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
