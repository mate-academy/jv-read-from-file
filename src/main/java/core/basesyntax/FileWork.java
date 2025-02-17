package core.basesyntax;

import java.io.*;
import java.util.*;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        System.out.println("🔍 Full path: " + file.getAbsolutePath());

        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.toLowerCase().split("[^a-zA-Z]+");

                for (String word : tokens) {
                    if (word.startsWith("w") && !word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found: " + fileName);
            return new String[0];
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading file: " + fileName, e);
        }

        Collections.sort(words);
        return words.toArray(new String[0]);
    }
}
