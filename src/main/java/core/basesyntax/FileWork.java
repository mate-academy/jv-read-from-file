package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        String[] tokens = stringBuilder.toString().toLowerCase().split("\\s+");

        int count = 0;
        for (String token : tokens) {
            String cleaned = token.replaceAll("[^a-zA-Z]", "");
            if (!cleaned.isEmpty()) {
                count++;
            }
        }

        String[] wordsFromFile = new String[count];
        int index = 0;
        for (String token : tokens) {
            String cleaned = token.replaceAll("[^a-zA-Z]", "");
            if (!cleaned.isEmpty()) {
                wordsFromFile[index++] = cleaned;
            }
        }
        int neededWords = 0;
        for (String word : wordsFromFile) {
            if (word.startsWith("w")) {
                neededWords++;
            }
        }

        String[] result = new String[neededWords];
        index = 0;
        for (String word : wordsFromFile) {
            if (word.startsWith("w")) {
                result[index++] = word;
            }
        }
        Arrays.sort(result);

        return result;
    }
}
