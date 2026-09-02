package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final int SPECIFIED_NUMBER = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
            if (builder.isEmpty()) {
                return new String[0];
            }
            String[] words = builder.toString().toLowerCase().split("\\W+");
            int lenght = 0;
            for (String word: words) {
                if (word.charAt(SPECIFIED_NUMBER) == SPECIFIED_CHARACTER) {
                    lenght++;
                }
            }
            String[] wordsWithOnlyW = new String[lenght];
            int i = 0;
            for (String word: words) {
                if (word.charAt(0) == SPECIFIED_CHARACTER) {
                    wordsWithOnlyW[i] = word;
                    i++;
                }
            }
            Arrays.sort(wordsWithOnlyW);
            return wordsWithOnlyW;
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
