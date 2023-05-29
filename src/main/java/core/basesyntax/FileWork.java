package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("[^a-zA-Z0-9']+");
                for (String token : tokens) {
                    if (token.toLowerCase().startsWith("w")) {
                        String filtered = token.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                        filteredWords.add(filtered);
                    }
                }
            }
        } catch (IOException e) {
            return new String[0];
        }
        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result, String.CASE_INSENSITIVE_ORDER);
        return result;
    }
}
