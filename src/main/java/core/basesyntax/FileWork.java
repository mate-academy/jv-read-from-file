package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }

            String content = contentBuilder.toString().trim();

            if (content.isEmpty()) {
                return new String[0];
            }

            String[] words = content.split("[\\s\\p{Punct}]+");

            List<String> filteredWords = Arrays.stream(words)
                    .filter(word -> word.toLowerCase().startsWith("w"))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

            // Сортировка результатов
            filteredWords.sort(String::compareTo);

            return filteredWords.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            String fileName = "test" + i;
            String[] fileResult = fileWork.readFromFile(fileName);
            System.out.println("Result for " + fileName + ": " + Arrays.toString(fileResult));
            result.addAll(Arrays.asList(fileResult));
        }

        System.out.println("Combined Result: " + result);
    }
}
