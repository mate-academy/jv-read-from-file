package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String regex = "\\b[wW]\\w*\\b";

        try {
            String words = new String(Files.readAllBytes(Paths.get(fileName)));

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(words);

            List<String> filteredWords = new ArrayList<>();
            while (matcher.find()) {
                filteredWords.add(matcher.group().toLowerCase(Locale.ROOT));
            }

            if (filteredWords.isEmpty()) {
                return new String[0];
            }

            Collections.sort(filteredWords);

            return filteredWords.toArray(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
