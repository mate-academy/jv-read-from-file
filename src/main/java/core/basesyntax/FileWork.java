package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File path = new File(fileName);
        StringBuilder result = new StringBuilder();

        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String value = file.readLine();
            while (value != null) {
                for (String word : value.split(" ")) {
                    if (word.toLowerCase().startsWith("w")) {
                        String formattedWord = word.toLowerCase().replaceAll("[^a-z]", "");
                        result.append(formattedWord).append(" ");
                    }
                }
                value = file.readLine();
            }
        } catch (Exception e) {
            System.out.println("File not find " + e);
        }

        if (!result.toString().isEmpty()) {
            String[] arrayOfWords = result.toString().split(" ");
            Arrays.sort(arrayOfWords);
            return arrayOfWords;
        }

        return new String[] {};
    }
}
