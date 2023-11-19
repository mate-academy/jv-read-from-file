package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FILTER_CHARACTER = 'w';
    private int matchCounter = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                matcher(line, stringBuilder);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from file", e);
        }
        if (matchCounter == 0) {
            return new String[0];
        }
        String[] result = new String[matchCounter];
        int index = 0;
        for (String word : stringBuilder.toString()
                .split(" ")) {
            result[index++] = word;
        }
        Arrays.sort(result);
        return result;
    }

    private void matcher(String line, StringBuilder stringBuilder) {
        for (String word : line.split(" ")) {
            word = word.toLowerCase();
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.charAt(0) == FILTER_CHARACTER) {
                stringBuilder
                        .append(word.trim())
                        .append(" ");
                ++matchCounter;
            }
        }
    }
}
