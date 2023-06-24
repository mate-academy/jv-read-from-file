package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        // Regular expression pattern to match words starting with 'w'
        Pattern pattern = Pattern.compile("\\b[wW]\\w*\\b");

        List<String> words = new ArrayList<>();

        // Step 1: Read the text file and extract words
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                String[] lineWords = line.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
                words.addAll(Arrays.asList(lineWords));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0]; // Return an empty array if there is an error reading the file
        }

        // Step 2: Filter words starting with 'w'
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (pattern.matcher(word).matches()) {
                filteredWords.add(word);
            }
        }

        // Step 3: Sort the filtered words naturally
        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result, String.CASE_INSENSITIVE_ORDER);

        return result;
    }
}

