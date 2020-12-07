package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String STRING_START_WITH = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineSeparator = System.lineSeparator();
            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                stringBuilder.append(lineFromFile).append(lineSeparator);
                lineFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] splitedStringBuilderResult = stringBuilder
                .toString()
                .toLowerCase()
                .split("\\s+|\\.|,|:|;|'|!|\\?");
        List<String> wordsList = new ArrayList<>();
        for (String eachWord : splitedStringBuilderResult) {
            if (eachWord.startsWith(STRING_START_WITH)) {
                wordsList.add(eachWord);
            }
        }
        Collections.sort(wordsList);
        String[] sortedWords = new String[wordsList.size()];
        return wordsList.toArray(sortedWords);
    }
}
