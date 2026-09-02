package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return processFile(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }

    private String[] processFile(BufferedReader reader) throws IOException {
        String[] tempArray = new String[1000];
        int count = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\W+");
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    tempArray[count++] = word.toLowerCase();
                }
            }
        }

        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = tempArray[i];
        }
        Arrays.sort(result);
        return result;
    }
}
