package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char FINDING_CHAR = 'w';
    private static final String REGEX_SEPARATOR = " |" + System.lineSeparator();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String value = bufferedReader.readLine();
            while (value != null) {
                text.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (text.length() == 0) {
            return new String[]{};
        }
        return findWWords(text);
    }

    private String[] findWWords(StringBuilder stringBuilder) {
        List<String> splitedString = Arrays
                .asList(stringBuilder.toString().split(REGEX_SEPARATOR));
        List<String> finalResult = new ArrayList<String>();
        for (int i = 0; i < splitedString.size(); i++) {
            if (splitedString.get(i).toLowerCase().charAt(0) == FINDING_CHAR) {
                finalResult.add(splitedString.get(i).toLowerCase().replaceAll("[^\\w]", ""));
            }
        }
        Collections.sort(finalResult);
        return finalResult.toArray(new String[]{});
    }
}
