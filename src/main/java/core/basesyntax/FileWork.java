package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char LETTER = 'w';

    public String[] readFromFile(String fileName) {
        String data = readFile(fileName).toLowerCase();
        if (data.length() == 0) {
            return new String[0];
        }

        String[] words = data.split("\\W+");
        String[] result = new String[countWordsBeginsLetter(words, LETTER)];
        int index = 0;
        for (String word : words) {
            if (word.charAt(0) == LETTER) {
                result[index] = word;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private int countWordsBeginsLetter(String[] words, char letter) {
        int count = 0;
        for (String word : words) {
            if (word.charAt(0) == letter) {
                count++;
            }
        }
        return count;
    }

    private String readFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return builder.toString();
    }
}
