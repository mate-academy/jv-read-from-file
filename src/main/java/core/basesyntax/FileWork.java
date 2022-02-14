package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    private static final char FILTER_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }

        String fileContent = getFileContent(file);
        String[] allWords = fileContent.split("\\s+");
        for (int i = 0; i < allWords.length; i++) {
            allWords[i] = removeNonLetters(allWords[i]);
        }

        String[] wordsStartingWithW = getLinesStartingAt(allWords);
        Arrays.sort(wordsStartingWithW);
        return wordsStartingWithW;
    }

    private String[] getLinesStartingAt(String[] lines) {
        List<String> filteredLines = new ArrayList<>(lines.length);
        for (String line : lines) {
            line = line.toLowerCase();
            if (line.charAt(0) == FILTER_CHARACTER) {
                filteredLines.add(line);
            }
        }
        return filteredLines.toArray(new String[0]);
    }

    private String removeNonLetters(String line) {
        return line.replaceAll("\\W", "");
    }

    private String getFileContent(File file) {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                fileContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return fileContent.toString();
    }
}
