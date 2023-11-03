package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class FileWork {

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<String> wordsStartingWithW = new ArrayList<>();
            Pattern wordPattern = Pattern.compile("\\b\\p{L}+\\b");

            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                line = Normalizer.normalize(line, Normalizer.Form.NFD);
                line = line.replaceAll("[^\\p{ASCII}]", "");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.replaceAll("[^\\p{L}]", ""); // Remove punctuation
                    if (word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }

            Collections.sort(wordsStartingWithW, Collator.getInstance()); // Natural sorting
            return wordsStartingWithW.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0]; // Return an empty array in case of an error
        }
    }

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] filteredWords = fileWork.readFromFile("yourFileName.txt");

        if (filteredWords.length > 0) {
            for (String word : filteredWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No words starting with 'w' found or an error occurred.");
        }
    }
}

