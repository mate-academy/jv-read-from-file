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
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            Pattern re = Pattern.compile("[^A-Za-z0-9 ]+",Pattern.CASE_INSENSITIVE);
            Matcher m = re.matcher(builder.toString());
            String [] anotherValue = m.replaceAll("").toLowerCase().split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (String start : anotherValue) {
                if (start.startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(start).append(System.lineSeparator());
                }
            }
            if (stringBuilder.length() != 0) {
                String[] result = stringBuilder.toString().split(System.lineSeparator());
                Arrays.sort(result);
                return result;
            } else {
                String[] result = new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return new String[0];
    }
}


