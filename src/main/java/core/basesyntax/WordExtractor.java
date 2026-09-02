package core.basesyntax;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordExtractor {
    public WordExtractor() {
    }

    public String[] extract(String data) {
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]+",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data);
        String[] result = matcher.replaceAll("").toLowerCase().split(" ");
        Arrays.sort(result);
        if (result.length == 1) {
            return result;
        }
        for (String word : result) {
            if (word.charAt(0) == 'w') {
                builder.append(word).append(" ");
            }
        }
        return builder.toString().split(" ");
    }
}

