package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String fileContent = builder.toString();
            String[] words = fileContent.split("\\s+");
            List<String> filteredWords = new ArrayList<>();
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    word = word.replaceAll("[^a-zA-Z0-9]", "");
                    filteredWords.add(word);
                }
            }
            return filteredWords.stream().map(String::toLowerCase).sorted().toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
