package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().split("\\s+");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replaceAll("^[^a-zA-Z]+|[^a-zA-Z]+$", "").toLowerCase();
            }

            int count = 0;
            for (String word : words) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    count++;
                }
            }
            String[] filteredWords = new String[count];
            int index = 0;
            for (String word : words) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    filteredWords[index++] = word;
                }
            }
            Arrays.sort(filteredWords);
            return filteredWords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
