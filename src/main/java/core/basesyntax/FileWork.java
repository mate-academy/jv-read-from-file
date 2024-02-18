package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            return filterWords(content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return new String[0];
        }
    }

    private String[] filterWords(String content) {
        if (content == null || content.isEmpty()) {
            return new String[0];
        }

        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = content.split("[\\s\\p{Punct}]+");

        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                wordCountMap.put(cleanWord, wordCountMap.getOrDefault(cleanWord, 0) + 1);
            }
        }

        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                resultList.add(entry.getKey());
            }
        }

        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }
}
