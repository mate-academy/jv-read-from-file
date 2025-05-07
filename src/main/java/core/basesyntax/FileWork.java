package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {

    public String[] readFromFile(String filename) {
        String content;
        try {
            byte[] bytes = Files.readAllBytes(Path.of(filename));
            content = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }

        List<String> words = extractWords(content);
        List<String> filteredWords = filterWordsStartingWithW(words);

        return sortAndConvertToArray(filteredWords);
    }

    private List<String> extractWords(String inputStr) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(inputStr);

        while (matcher.find()) {
            words.add(matcher.group().toLowerCase());
        }

        return words;
    }

    private List<String> filterWordsStartingWithW(List<String> words) {
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith("w")) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

    private String[] sortAndConvertToArray(List<String> words) {
        String[] sortedWords = words.toArray(new String[0]);
        Arrays.sort(sortedWords);
        return sortedWords;
    }
}
