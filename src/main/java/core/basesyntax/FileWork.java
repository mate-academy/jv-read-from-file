package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> splitedWords = new ArrayList<>();
        ArrayList<String> finalWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                splitedWords.addAll(List.of(line.split("\\W+")));
                line = reader.readLine();
            }
            for (String splitedWord : splitedWords) {
                if (splitedWord.charAt(0) == 'w' || splitedWord.charAt(0) == 'W') {
                    finalWords.add(splitedWord);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Not able to find a file! ", e);
        }
        String[] result = new String[finalWords.size()];
        result = finalWords.toArray(result);
        return Arrays.stream(result)
                .map(String::toLowerCase)
                .sorted()
                .toArray(String[]::new);
    }
}
