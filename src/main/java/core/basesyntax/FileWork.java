package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] result;
        String[] words;
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            while (value != -1) {
                if ((value >= 65 && value <= 90)
                        || (value >= 97 && value <= 122)
                        || value == 32) {
                    stringBuilder.append((char) value);
                } else if (value == 10) {
                    stringBuilder.append(" ");
                }
                value = bufferedReader.read();
            }
            words = stringBuilder.toString().toLowerCase().split(" ");
            Arrays.sort(words);
            int count = 0;
            result = new String[words.length];
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    result[count] = word;
                    count++;
                }
            }
            result = Arrays.copyOf(result, count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.lineSeparator());
        return result;
    }
}

