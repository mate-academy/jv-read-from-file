package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class FileWork {
    public String[] readFromFile(String fileName) {

        String fileText;
        try {
            File file = new File(fileName);
            List<String> lines = Files.readAllLines(file.toPath());
            fileText = lines.stream().reduce("", (a, b) -> a + " " + b);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (fileText == null) {
            return new String[0];
        }

        List<String> result;
        try {
            List<String> separatedAndFilteredWords = Arrays.stream(fileText.split("\\s+"))
                    .map(String::toLowerCase)
                    .filter((word) -> word.startsWith("w")).toList();
            String regexPattern = "[\\x21-\\x2F\\x3A-\\x40\\x5B-\\x60\\x7B-\\x7E]";
            String replacementString = "";

            System.out.println(separatedAndFilteredWords);
            result = separatedAndFilteredWords.stream()
                    .map(word -> word.replaceAll(regexPattern, replacementString))
                    .sorted().toList();

        } catch (PatternSyntaxException e) {
            throw new RuntimeException("Wrong pattern format", e);
        }

        return result.toArray(new String[result.size()]);
    }
}
