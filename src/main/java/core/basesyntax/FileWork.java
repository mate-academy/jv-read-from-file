package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder filteredWorlds = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                String[] words = line.replaceAll("[^\\w\\s]", "").split("\\s+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        if (filteredWorlds.length() > 0) {
                            filteredWorlds.append(",");
                        }
                        filteredWorlds.append(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File read error", e);
        }
        String[] result;
        if (filteredWorlds.length() > 0) {
            result = filteredWorlds.toString().split(",");
        } else {
            result = new String[0];
        }
        Arrays.sort(result);
        return result;
    }
}
