package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX = "[^A-Za-z0-9 ]+";

    public String[] readFromFile(String fileName) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String result = Pattern.compile(REGEX,Pattern.CASE_INSENSITIVE).matcher(line)
                        .replaceAll("").toLowerCase();
                String[] words = result.split(" ");
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        strings.add(word);
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] filteredWords = new String[strings.size()];
        strings.toArray(filteredWords);
        Arrays.sort(filteredWords);

        return filteredWords;
    }
}

