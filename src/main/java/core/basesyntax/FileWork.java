package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final int FIRST_LETTER_INDEX = 0;
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            stringBuilder = new StringBuilder();
            line = reader.readLine();
            if (line == null) {
                return new String[]{};
            }
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        StringBuilder wordsStartWithW = new StringBuilder();
        String[] words = stringBuilder.toString().split("\\W+");
        for (String word : words) {
            char[] letters = word.toLowerCase().toCharArray();
            if (letters[FIRST_LETTER_INDEX] == SPECIFIED_CHARACTER) {
                wordsStartWithW.append(word.toLowerCase()).append(" ");
            }
        }
        if (wordsStartWithW.toString().equals("")) {
            return new String[0];
        }
        String[] result = wordsStartWithW.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
