package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] wordsArray = new String[] {};
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("[\\s,.;:!?]+");
                wordsArray = concatenateArrays(wordsArray, words);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        return Arrays.stream(wordsArray)
                .filter(word -> word.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }

    private String[] concatenateArrays(String[] arr1, String[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        String[] result = Arrays.copyOf(arr1, arr1Length + arr2Length);
        System.arraycopy(arr2, 0, result, arr1Length, arr2Length);
        return result;
    }
}

