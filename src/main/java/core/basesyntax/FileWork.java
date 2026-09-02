package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    // Method to read words from a file, filter them, and return the result as a sorted array
    public static String[] readFromFile(String filename) {
        String[] words = new String[0]; // Array to store words

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read each line from the file
                String[] lineWords = line.toLowerCase().split("[\\s\\p{Punct}]+");
                //Convert to lowercase and split to words using spaces and punctuation as delimiters

                for (String word : lineWords) {
                    if (word.startsWith("w")) { // Filter words starting with "w"
                        words = addWordToArray(words, word); // Add the word to the array
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.sort(words); // Sort the array naturally

        return words;
    }

    private static String[] addWordToArray(String[] words, String word) {
        String[] newArray = new String[words.length + 1]; // Create a new array with increased size
        System.arraycopy(words, 0, newArray, 0, words.length);
        // Copy the existing words to the new array
        newArray[words.length] = word; // Add the new word to the end of the new array
        return newArray;
    }
}

