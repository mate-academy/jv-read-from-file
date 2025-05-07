package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    private static final Pattern wordPattern =
            Pattern.compile("(\\bw\\w+)", Pattern.CASE_INSENSITIVE);

    public String[] readFromFile(String fileName) {
        List<String> lines;
        List<String> words = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + fileName);
        }
        for (String line : lines) {
            wordPattern.matcher(line).results()
                    .forEach(matchResult -> words.add(matchResult.group().toLowerCase()));
        }
        Collections.sort(words);
        return words.toArray(new String[0]);
    }
}
