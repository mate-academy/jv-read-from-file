package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String REGEX_LETTER_W = "\\b[wW]\\w*\\b";
    private static final String REGEX_SPECIAL_SYMBOLS = "[^a-zA-Z\\s]";
    private static final String REPLACEMENT = "";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value);
                builder.append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException("File is not exist");
        }
        String cleanText = builder.toString().replaceAll(REGEX_SPECIAL_SYMBOLS, REPLACEMENT);
        Pattern pattern = Pattern.compile(REGEX_LETTER_W);
        Matcher matcher = pattern.matcher(cleanText);
        builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(matcher.group().toLowerCase()).append(SPACE);
        }
        if (builder.isEmpty()) {
            return new String[0];
        } else {
            String[] newArray = builder.toString().split(SPACE);
            Arrays.sort(newArray);
            return newArray;
        }
    }
}
