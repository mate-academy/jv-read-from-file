package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        //write your code here
        String[] result = new String[]{};
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    char[] chars = word.toCharArray();
                    if (chars[0] == 'w') {
                        appendWord(stringBuilder, word, chars);
                        count++;
                    } else if (chars[0] == 'W') {
                        appendWord(stringBuilder, word, chars);
                        count++;
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (count == 0) {
            return result;
        } else {
            result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        }
    }

    private static void appendWord(StringBuilder stringBuilder, String word, char[] chars) {
        if (chars[chars.length - 1] == '.' || chars[chars.length - 1] == ','
                || chars[chars.length - 1] == '"' || chars[chars.length - 1] == '!'
                || chars[chars.length - 1] == '?') {
            String newWord = word.substring(0, word.length() - 1);
            stringBuilder.append(newWord.toLowerCase()).append(" ");
        } else {
            stringBuilder.append(word.toLowerCase()).append(" ");
        }
    }
}
