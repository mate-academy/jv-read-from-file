package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (Exception e) {
            throw new RuntimeException("Cant read a file!" + e);
        }
        String data = stringBuilder.toString().toLowerCase();
        String[] filteredData = data.split("[\\s\\n]+");
        String[] tempFilteredWords = new String[filteredData.length];
        int count = 0;
        for (String word : filteredData) {
            String cleanWord = word.replaceAll("[^a-z]", "");
            if (!cleanWord.isEmpty() && cleanWord.charAt(0) == 'w') {
                tempFilteredWords[count++] = cleanWord;
            }
        }
        String[] result = Arrays.copyOf(tempFilteredWords, count);
        Arrays.sort(result);
        return result;
    }
}
