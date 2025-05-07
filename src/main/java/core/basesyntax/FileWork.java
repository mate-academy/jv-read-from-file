package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String WORD_STARTS_WITH_W_REGEX = "\\b[wW]\\w*\\b";

    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(String.valueOf(Path.of(fileName))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile(WORD_STARTS_WITH_W_REGEX);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    filteredWords.add(matcher.group().toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(filteredWords);
        return filteredWords.toArray(new String[0]);
    }
}
