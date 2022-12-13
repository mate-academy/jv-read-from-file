package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    final char CORRECT_CAPITAL_LETTER = 'W';
    final char CORRECT_LETTER = 'w';
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
                    String[] words = value.split("\\W+");
                    for (String word : words) {
                        if (word.length() > 0 && (word.charAt(0) == CORRECT_CAPITAL_LETTER || word.charAt(0) == CORRECT_LETTER)) {
                            builder.append(word.toLowerCase()).append(" ");
                            value = reader.readLine();
                        }
                    }
                }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[]correctWords = builder.toString().split(" ");
        Arrays.sort(correctWords);
        return correctWords;
    }
}
