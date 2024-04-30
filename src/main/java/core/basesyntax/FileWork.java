package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }
            String content = builder.toString();
            Pattern pattern = Pattern.compile("\\b[wW]\\w*\\b");
            Matcher matcher = pattern.matcher(content);

            String[] matches = matcher.results()
                    .map(MatchResult::group)
                    .map(word -> word.replaceAll("[\\p{Punct}]", "").toLowerCase())
                    .toArray(String[]::new);

            Arrays.sort(matches);
            return matches;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
