package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public static List<String> readAndFilterWords(String filePath) {
        List<String> result = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] words = content.split("\\W+");

            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    result.add(word.toLowerCase());
                }
            }
            Collections.sort(result);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        String filePath = "src/core/basesyntax/words.txt";
        List<String> filteredWords = readAndFilterWords(filePath);
        System.out.println(filteredWords);
    }
}