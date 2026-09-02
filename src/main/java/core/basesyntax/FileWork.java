package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String fileContent = content.toString();
        return processedContent(fileContent);
    }

    private String[] processedContent(String content) {
        String[] words = content.split("\\W+");
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                filteredWords.add(word.toLowerCase());
            }
        }
        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
