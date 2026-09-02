package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private final StringBuilder matchingWordsBuilder = new StringBuilder();

    public String[] readFromFile(String filePath) {
        File file = new File(filePath);

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            System.out.println(lines);

            for (String line : lines) {
                extractWordsStartingWithW(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading file!", e);
        }

        String allWords = matchingWordsBuilder.toString().trim();

        if (allWords.isEmpty()) {
            return new String[0];
        }

        String[] result = allWords.split(" ");
        Arrays.sort(result);
        matchingWordsBuilder.setLength(0);

        return result;
    }

    private void extractWordsStartingWithW(String sentence) {
        String[] words = sentence.toLowerCase().split("[\\W+]");
        for (String word : words) {
            boolean startsWithW = word.matches("w[a-zA-Z]*");

            if (startsWithW) {
                matchingWordsBuilder.append(word).append(" ");
            }
        }
    }
}
