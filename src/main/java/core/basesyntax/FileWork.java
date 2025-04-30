package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile("\\b[wW]\\p{Alnum}+\\b");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    wordsStartingWithW.add(matcher.group().toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return wordsStartingWithW.stream().sorted().toArray(String[]::new);
    }
}
