package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIFIED_ARTICLE = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder builder1 = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder1.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String [] text = builder1.toString().toLowerCase().split(SPECIFIED_ARTICLE);
        int index = 0;
        StringBuilder builder2 = new StringBuilder();
        for (String word : text) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                index++;
                builder2.append(word).append(" ");
            }
        }
        String[] newText = new String[index];
        if (newText.length == 0) {
            return new String[0];
        }
        newText = builder2.toString().split(" ");
        Arrays.sort(newText);
        return newText;
    }
}
