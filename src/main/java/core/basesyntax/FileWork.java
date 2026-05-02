package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {

        String[] result;
        String res;

        try {
            String text = Files.readString(Path.of(fileName));

            if (text.isEmpty()) {
                return new String[0];
            }

            Pattern patternCorrectWords = Pattern.compile("\\b[wW][a-zA-Z]+");
            Matcher matcher = patternCorrectWords.matcher(text);
            StringBuilder builder = new StringBuilder();

            while (matcher.find()) {

                builder.append(matcher.group()).append(" ");

            }

            res = builder.toString().trim().toLowerCase();

            if (res.equals("")) {
                return new String[0];
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        result = res.split(" ");
        Arrays.sort(result);

        return result;
    }
}
