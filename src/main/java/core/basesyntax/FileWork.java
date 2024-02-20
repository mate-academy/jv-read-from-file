package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            String[] words = extractWords(content.toString());
            String[] filteredWords = filterWordsStartingWithSpecifiedCharacter(
                    words, SPECIFIED_CHARACTER);
            Arrays.sort(filteredWords);
            return filteredWords;
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + fileName, e);
        }
    }

    private String[] extractWords(String content) {
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(content.toLowerCase());
        ArrayList<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words.toArray(new String[0]);
    }

    private String[] filterWordsStartingWithSpecifiedCharacter(
            String[] words, String specifiedCharacter) {
        ArrayList<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith(specifiedCharacter)) {
                filteredWords.add(word);
            }
        }
        return filteredWords.toArray(new String[0]);
    }
}
