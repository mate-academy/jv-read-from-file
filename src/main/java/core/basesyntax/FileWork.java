package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final String REGEX_TO_SPLIT_LINES = " ";
    public static final String SPECIFIED_LETTER = "w";
    public static final String REGEX_TO_REMOVE_PUNCTUATIONS = "[!.,?]";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try {
            Files.readAllLines(Paths.get(fileName))
                    .stream()
                    .flatMap(line -> Arrays.stream(line.split(REGEX_TO_SPLIT_LINES)))
                    .filter(word -> word.toLowerCase().startsWith(SPECIFIED_LETTER))
                    .map(word -> word.replaceAll(REGEX_TO_REMOVE_PUNCTUATIONS, "").toLowerCase())
                    .sorted(String::compareToIgnoreCase)
                    .forEach(result::add);

        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }

        return result.toArray(new String[0]);
    }
}
