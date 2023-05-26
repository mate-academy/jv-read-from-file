package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String MASK_SEARCH = "\\b[w]\\w+\\b";
    private static final String WORD_SPLIT = " ";

    public String[] readFromFile(String fileName) {
        String[] split = new String[]{};
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value;
            while ((value = reader.readLine()) != null) {
                stringBuilder.append(value).append(System.lineSeparator());
            }
            String lowercaseLine = stringBuilder.toString().toLowerCase();
            Pattern pattern = Pattern.compile(MASK_SEARCH);
            Matcher matcher = pattern.matcher(lowercaseLine);
            stringBuilder = new StringBuilder();
            while (matcher.find()) {
                stringBuilder.append(matcher.group()).append(WORD_SPLIT);
            }
            if (stringBuilder.length() > 0) {
                split = stringBuilder.toString().split(WORD_SPLIT);
                Arrays.sort(split);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't not read file" + fileName, e);
        }
        return split;
    }
}
