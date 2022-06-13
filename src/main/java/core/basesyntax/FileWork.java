package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        int count = 0;
        int j = 0;
        StringBuilder stringResult = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringResult.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find a file", e);
        }
        Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(stringResult);
        String onlyChar = matcher.replaceAll(" ").toLowerCase();
        String[] array = onlyChar.split(" ");
        for (String line : array) {
            if (line.startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        String[] searchResult = new String[count];
        for (String line : array) {
            if (line.startsWith(SPECIFIED_CHARACTER)) {
                searchResult[j] = line;
                j++;
            }
        }
        Arrays.sort(searchResult);
        return searchResult;
    }
}
