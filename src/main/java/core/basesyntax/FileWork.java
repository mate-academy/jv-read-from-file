package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPEC_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builderWordsStartsWithW = new StringBuilder();
        StringBuilder builderWordsForAllFile = new StringBuilder();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File(fileName)))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builderWordsForAllFile.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file");
        }
        String[] wordsOfFile = builderWordsForAllFile.toString().toLowerCase()
                .replaceAll("[,!?\\.]", "")
                .split("\\s+");

        for (String st : wordsOfFile) {
            if (st.startsWith(SPEC_CHARACTER)) {
                builderWordsStartsWithW.append(st).append(" ");
            }
        }
        String[] wordsStartsWithW = builderWordsStartsWithW.toString().split(" ");
        Arrays.sort(wordsStartsWithW);
        if (builderWordsStartsWithW.toString().isEmpty()) {
            return new String[0];
        }
        return wordsStartsWithW;
    }
}
