package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int initialCapacity = 10;
        String[] filteredWords = new String[initialCapacity];
        int count = 0;
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    if (word.toLowerCase().startsWith("w")) {
                        String cleanWord = word.replaceAll("^[^a-zA-Z]+|[^a-zA-Z]+$",
                                "").toLowerCase();

                        if (!cleanWord.isEmpty()) {
                            if (count == filteredWords.length) {
                                filteredWords = Arrays.copyOf(filteredWords,
                                        filteredWords.length * 2);
                            }

                            filteredWords[count++] = cleanWord;
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + fileName, e);
        }
        if (count == 0) {
            return new String[0];
        }

        String[] result = Arrays.copyOf(filteredWords, count);
        Arrays.sort(result);
        return result;
    }
}
