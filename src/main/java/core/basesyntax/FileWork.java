package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_LETTER = "w";
    private static final String DIVIDER = " ";
    private static final String REGEX = "[\\W]+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(DIVIDER);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read a file" + fileName, e);
        }
        String[] results = builder.toString().split(REGEX);
        StringBuilder filteredWords = new StringBuilder();
        for (String result : results) {
            String lowerCase = result.toLowerCase();
            if (lowerCase.startsWith(SPECIFIED_LETTER)) {
                filteredWords.append(lowerCase).append(DIVIDER);
            }
        }
        if (filteredWords.length() == 0) {
            return new String[0];
        }
        String[] finalResults = filteredWords.toString().split(DIVIDER);
        Arrays.sort(finalResults);
        return finalResults;
    }
}
