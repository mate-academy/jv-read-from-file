package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final Pattern PUNCTUATION_TO_REPLACE = Pattern.compile("[.!?\\-]");
    private static final String REPLACEMENT_FOR_PUNCTUATION = "";

    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (var strs = new BufferedReader(new FileReader(fileName))) {
            String next;
            while ((next = strs.readLine()) != null) {
                String[] tmp = next.split(" ");
                for (String str : tmp) {
                    str = str.toLowerCase();
                    if (str.startsWith(SPECIFIED_CHARACTER)) {
                        String tmpString = replacePunctuation(str);
                        result.append(tmpString).append(" ");
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong", e);
        }
        if (result.length() == 0) {
            return new String[]{};
        }
        String[] returnResult = result.toString().strip().split(" ");
        Arrays.sort(returnResult);
        return returnResult;
    }

    private String replacePunctuation(String str) {
        Matcher matcher = PUNCTUATION_TO_REPLACE.matcher(str);
        return matcher.replaceAll(REPLACEMENT_FOR_PUNCTUATION);
    }
}
