package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";
    public static final String EMPTY_CHARACTER = " ";

    public String[] readFromFile(String fileName) {
        String content = readFile(fileName);

        String[] filteredWords = processContent(content);

        Arrays.sort(filteredWords);
        return filteredWords;
    }

    private String readFile(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append(EMPTY_CHARACTER);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
        return contentBuilder.toString();
    }

    private String[] processContent(String content) {
        String[] words = removePunctuation(content).split("\\s+");

        String[] tempWords = new String[words.length];
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty() && word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                tempWords[count++] = word.toLowerCase();
            }
        }

        String[] filteredWords = Arrays.copyOf(tempWords, count);

        Arrays.sort(filteredWords);

        return filteredWords;
    }

    private String removePunctuation(String string) {
        return string.replaceAll("[^a-zA-Z\\s]", "");
    }
}
