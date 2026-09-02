package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            return new String[0];
        }

        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(" ");
            }
            
        } catch (IOException e) {
            return new String[0];
        }

        String[] wordsFromFile = sb.toString().split("[ .,?!`]+");

        sb.setLength(0);

        for (String word : wordsFromFile) {
            if (word.toLowerCase().startsWith("w")) {
                sb.append(word.toLowerCase()).append(" ");
            }
        }

        String result = sb.toString().trim();

        if (result.isEmpty()) {
            return new String[0];
        }
        
        String[] words = result.split(" "); 
        Arrays.sort(words);

        return words;
    }
}
