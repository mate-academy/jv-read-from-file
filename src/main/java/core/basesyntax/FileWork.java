package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private StringBuilder builder = new StringBuilder();
    private int count = 0;
    private String[] startsWithW;
    private String[] splitText;

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return deleteNotW(builder.toString());
    }

    private String[] deleteNotW(String text) {
        splitText = text.split("\\W+");
        for (String word: splitText) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        startsWithW = new String[count];
        for (String word: splitText) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                startsWithW[count-- - 1] = word.toLowerCase();
            }
        }
        Arrays.sort(startsWithW);
        return startsWithW;
    }
}
