package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String[] result;
        int wordCount = 0;
        int arrayCount = 0;
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] words;
            while ((line = reader.readLine()) != null) {
                words = line.split("\\s+");
                for (String word : words) {
                    if (word.startsWith("w") || word.startsWith("W")) {
                        wordCount++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + e);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] words;
            result = new String[wordCount];
            while ((line = reader.readLine()) != null) {
                words = line.split("\\s+");
                for (String word : words) {
                    if (word.startsWith("w") || word.startsWith("W")) {
                        result[arrayCount] = word.replaceAll("\\p{Punct}", "").toLowerCase();
                        arrayCount++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + e);
        }
        Arrays.sort(result);
        return result;
    }
}
