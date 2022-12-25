package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        // Declare a File object to represent the file
        File file = new File(fileName);
        // Create a StringBuilder to store the cleaned words
        StringBuilder sb = new StringBuilder();
        int count = 0;
        try {
            // Create a BufferedReader to read the file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // Create a StringBuilder to store the contents of the file
            StringBuilder stringBuilder = new StringBuilder();
            // Read the first line of the file
            String value = bufferedReader.readLine();
            // Continue reading lines until there are no more lines to read
            while (value != null) {
                // Append the current line to the StringBuilder, followed by a line separator
                stringBuilder.append(value).append(System.lineSeparator());
                // Read the next line
                value = bufferedReader.readLine();
            }
            // If the StringBuilder is empty (i.e. the file was empty), return an empty array
            if (stringBuilder.length() < 1) {
                return new String[0];
            }
            // Initialize a variable to store the cleaned version of each word
            String cleanedWord = "";
            // Split the contents of the file into an array of words,
            // removing punctuation and converting to lowercase
            String[] words = stringBuilder.toString()
                    .replaceAll("\\p{Punct}", "")
                    .toLowerCase().split(" ");
            for (String word : words) {
                // Remove any words that contain non-word characters (except for the letter 'w')
                cleanedWord = word.replaceAll("\\b(?!w)\\w+\\b", "");
                // If the cleaned word is more than one character,
                // add it to the StringBuilder and increment the count
                if (cleanedWord.length() > 1) {
                    count++;
                    sb.append(cleanedWord + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        // If the StringBuilder is empty (i.e. no words were added to it), return an empty array
        if (sb.length() < 1) {
            return new String[0];
        }
        // Remove the final line separator from the StringBuilder
        sb.substring(0, sb.length() - 1);
        // Initialize an array to hold the cleaned words
        String[] result = new String[count];
        // Split the StringBuilder into an array of strings using the line separator
        result = sb.toString().split(System.lineSeparator());
        // Sort the array of strings alphabetically
        Arrays.sort(result);
        return result;
    }
}
