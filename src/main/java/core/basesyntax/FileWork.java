package core.basesyntax;

import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] words = fileName.split(" ");
        String[] filteredWords = new String[words.length];
        int count = 0;
        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                String filteredWord = word.replaceAll("\\p{Punct}", "");
                // Convert to lowercase
                filteredWord = filteredWord.toLowerCase();
                // Add the filtered word to the array
                filteredWords[count++] = filteredWord;
            }
        }

        // Sort the filtered words
        Arrays.sort(filteredWords, 0, count);

        // Resize the array to remove null elements
        return Arrays.copyOf(filteredWords, count);
    }

}
