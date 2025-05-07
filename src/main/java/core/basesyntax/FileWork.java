package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[\\s,;.!?]+");
                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
                    if (!cleanedWord.isEmpty() && cleanedWord.startsWith(SPECIFIED_CHARACTER)) {
                        wordsStartingWithW.add(cleanedWord);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }

        wordsStartingWithW.sort(String.CASE_INSENSITIVE_ORDER);
        return wordsStartingWithW.toArray(new String[0]);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java FileWork <filename>");
            return;
        }
        String fileName = args[0];
        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile(fileName);
        Arrays.stream(result).forEach(System.out::println);
    }
}
