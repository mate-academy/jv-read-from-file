package core.basesyntax;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String data = readFile(fileName);

        String separateOnlyWordsForResult = generateReport(data);

        if (separateOnlyWordsForResult.isEmpty()) {
            return new String[0];
        }

        String[] resultArray = separateOnlyWordsForResult.toLowerCase()
                .split(System.lineSeparator());
        Arrays.sort(resultArray);

        return resultArray;
    }

    private static String generateReport(String data) {
        String[] splitWordsWithoutPunctuationMarks = data.split("\\W+");
        StringBuilder separateOnlyWordsForResult = new StringBuilder();

        for (String word : splitWordsWithoutPunctuationMarks) {
            String[] splitWord = word.split("");

            if ("w".equals(splitWord[0]) || "W".equals(splitWord[0])) {
                separateOnlyWordsForResult.append(word).append(System.lineSeparator());
            }
        }
        return separateOnlyWordsForResult.toString();
    }

    private String readFile(String fileName) {
        StringBuilder data = new StringBuilder();

        try (FileReader reader = new FileReader(fileName)) {
            int value;
            while ((value = reader.read()) != -1) {
                data.append((char)value);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return data.toString();
    }
}
