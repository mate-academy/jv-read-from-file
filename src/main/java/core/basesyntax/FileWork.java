package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String KEY_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] readingLine = line.toLowerCase().split("\\W+");
                for (String wordInLine : readingLine) {
                    if (wordInLine.toLowerCase().startsWith(KEY_CHARACTER)) {
                        stringBuilder.append(wordInLine).append(" ");
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read file " + fileName, e);
        }
        String[] wordsStartWithW = stringBuilder.toString().split(" ");
        Arrays.sort(wordsStartWithW);
        return stringBuilder.length() == 0 ? new String[]{} : wordsStartWithW;
    }
}
