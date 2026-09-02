package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String content = bufferedReader.readLine();
            while (content != null) {
                stringBuilder.append(content).append(" ");
                content = bufferedReader.readLine();
            }
            Pattern re = Pattern.compile("[^A-Za-z0-9 ]+", Pattern.CASE_INSENSITIVE);
            Matcher m = re.matcher(stringBuilder.toString());
            String[] dividedContent = m.replaceAll("").toLowerCase().split(" ");
            StringBuilder builder = new StringBuilder();
            for (String s : dividedContent) {
                if (s.startsWith(SPECIFIED_CHARACTER)) {
                    builder.append(s).append(System.lineSeparator());
                }
            }
            String[] result = builder.toString().split(System.lineSeparator());
            if (Objects.equals(result[0], "")) {
                return new String[0];
            } else {
                Arrays.sort(result);
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found",e);
        }
    }
}
