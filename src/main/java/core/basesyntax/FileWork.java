package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> filterWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line,
                        " \t" + System.lineSeparator() + ",.:;?![]{}()<>\"'");
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken().toLowerCase().replaceAll("^a-za-Z","");
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        filterWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return filterWords.stream().sorted().toArray(String[]::new);
    }
}
