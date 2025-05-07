package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String REGULAR_EXPRESSION_FOR_SPLIT = "[| ,-.'!?\"\n\r]";
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        File readFile = new File(fileName);
        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader(readFile))) {
            String readLineFile = bufferedReader.readLine();
            StringBuilder readFileBuilder = new StringBuilder();
            while (readLineFile != null) {
                readFileBuilder.append(readLineFile)
                        .append(System.lineSeparator());
                readLineFile = bufferedReader.readLine();
            }
            String[] splitReadFile = readFileBuilder
                    .toString()
                    .toLowerCase()
                    .split(REGULAR_EXPRESSION_FOR_SPLIT);

            int newArrayLength = 0;
            for (String word: splitReadFile) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    newArrayLength++;
                }
            }
            String[] finalArrayWords = new String[newArrayLength];
            int finalArrayWordsIndex = 0;
            for (String word: splitReadFile) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    finalArrayWords[finalArrayWordsIndex++] = word;
                }
            }
            Arrays.sort(finalArrayWords);
            return finalArrayWords;
        } catch (IOException e) {
            throw new RuntimeException("File does not read",e);
        }
    }
}
