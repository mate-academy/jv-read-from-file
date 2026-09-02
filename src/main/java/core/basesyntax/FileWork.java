package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String LETTER_W = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sortedWords = new StringBuilder();
        try {
            List<String> conntentOfFile = Files.readAllLines(file.toPath());
            String [] wordsOfContent = conntentOfFile.toString().toLowerCase().split("\\W");
            for (String word:wordsOfContent) {
                if (word.startsWith(LETTER_W)) {
                    sortedWords.append(word).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        String[] result = sortedWords.toString().split(" ");
        Arrays.sort(result);
        return sortedWords.length() == 0 ? new String [0] : result;
    }
}
