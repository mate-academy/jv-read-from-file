package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] filteredWords = new String[50];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {
                        String filteredWord = word.replaceAll("\\p{Punct}", "").toLowerCase();
                        filteredWords[count] = filteredWord;
                        count++;
                    }
                }
            }
            String[] result = new String[count];
            System.arraycopy(filteredWords, 0, result, 0, count);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
}
