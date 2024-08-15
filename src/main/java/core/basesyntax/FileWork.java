package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String input;
        try {
            input = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String onlyWordsString = input.replaceAll("\\b[^a-zA-Z]+", " ").toLowerCase();
        String[] onlyWordsArr = onlyWordsString.split(" ");
        Pattern filterPattern = Pattern.compile("\\b[Ww][a-zA-Z]+");
        String[] finalArray = Arrays.stream(onlyWordsArr)
                .filter(filterPattern.asPredicate())
                .toArray(String[]::new);
        Arrays.sort(finalArray);
        return finalArray;
    }
}
