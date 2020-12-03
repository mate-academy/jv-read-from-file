package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder wordsStartedW = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] line = value.split(" ");
                for (String words : line) {
                    if (words.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        wordsStartedW.append(words.replaceAll("[?!.,]", "").toLowerCase())
                                .append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't be read", e);
        }
        if (wordsStartedW.length() == 0) {
            return new String[]{};
        }
        String[] finalArray = wordsStartedW.toString().split(" ");
        Arrays.sort(finalArray);
        return finalArray;
    }
}
