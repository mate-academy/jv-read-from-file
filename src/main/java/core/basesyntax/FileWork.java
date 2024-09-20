package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    words.add(matcher.group());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        List<String> filterwords = words.stream()
                .filter(word -> word.toLowerCase().startsWith("w"))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());

        if (filterwords.isEmpty()) {
            return new String[]{};
        }

        return filterwords.toArray(new String[0]);
    }
}
