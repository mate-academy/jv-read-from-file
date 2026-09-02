package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String lineValue = bufferedReader.readLine();
            while (lineValue != null) {
                char targetChar = 'w';
                String[] splitWords = lineValue.split("\\W+");

                for (String splitWord : splitWords) {
                    String word = splitWord.toLowerCase();
                    char[] chars = word.toCharArray();
                    if (chars[0] == targetChar) {
                        stringBuilder.append(word).append(" ");
                    }
                }
                lineValue = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file", e);
        } catch (IOException e) {
            throw new RuntimeException("RuntimeException", e);
        }

        String result = stringBuilder.toString().trim();

        if (result.length() == 0) {
            return new String[0];
        }

        String[] split = result.split(" ");
        Arrays.sort(split);
        return split;
    }
}
